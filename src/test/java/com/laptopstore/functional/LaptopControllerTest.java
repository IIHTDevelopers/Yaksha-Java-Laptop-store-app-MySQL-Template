package com.laptopstore.functional;

import static com.laptopstore.utils.MasterData.getLaptopDTO;
import static com.laptopstore.utils.MasterData.getLaptopDTOList;
import static com.laptopstore.utils.MasterData.getLaptopDTOPage;
import static com.laptopstore.utils.TestUtils.businessTestFile;
import static com.laptopstore.utils.TestUtils.currentTest;
import static com.laptopstore.utils.TestUtils.testReport;
import static com.laptopstore.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.laptopstore.controller.LaptopController;
import com.laptopstore.dto.LaptopDTO;
import com.laptopstore.service.LaptopService;
import com.laptopstore.utils.MasterData;

@WebMvcTest(LaptopController.class)
@AutoConfigureMockMvc
public class LaptopControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LaptopService laptopService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testGetAllLaptops() throws Exception {
		Page<LaptopDTO> laptopDTOS = getLaptopDTOPage();

		when(this.laptopService.getAllLaptops(any(Pageable.class))).thenReturn(laptopDTOS);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/laptops")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(laptopDTOS)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testGetLaptopById() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();
		when(this.laptopService.getLaptopById(eq(laptopDTO.getId()))).thenReturn(laptopDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/laptops/" + laptopDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(laptopDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testCreateLaptop() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();

		when(this.laptopService.createLaptop(any(LaptopDTO.class))).thenReturn(laptopDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/laptops")
				.content(MasterData.asJsonString(laptopDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(laptopDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
	public void testUpdateLaptop() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();

		when(this.laptopService.updateLaptop(eq(laptopDTO.getId()), any(LaptopDTO.class))).thenReturn(laptopDTO);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/laptops/" + laptopDTO.getId())
				.content(MasterData.asJsonString(laptopDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(laptopDTO)) ? "true"
						: "false",
				businessTestFile);
	}

	@Test
    public void testDeleteLaptop() throws Exception {
        when(this.laptopService.deleteLaptop(any(Long.class))).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/laptops/1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        yakshaAssert(currentTest(),
                result.getResponse().getStatus() == HttpStatus.NO_CONTENT.value() ? "true" : "false",
                businessTestFile);
    }

	@Test
	public void testSearchLaptopsByName() throws Exception {
		List<LaptopDTO> laptops = getLaptopDTOList();

		when(this.laptopService.searchLaptopsByName(any(String.class))).thenReturn(laptops);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/laptops/search/by-name?name=Dell")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				result.getResponse().getContentAsString().contentEquals(MasterData.asJsonString(laptops)) ? "true"
						: "false",
				businessTestFile);
	}
}
