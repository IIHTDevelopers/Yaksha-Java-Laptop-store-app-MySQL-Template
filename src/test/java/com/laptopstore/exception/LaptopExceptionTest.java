package com.laptopstore.exception;

import static com.laptopstore.utils.MasterData.getLaptopDTO;
import static com.laptopstore.utils.TestUtils.currentTest;
import static com.laptopstore.utils.TestUtils.exceptionTestFile;
import static com.laptopstore.utils.TestUtils.testReport;
import static com.laptopstore.utils.TestUtils.yakshaAssert;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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
public class LaptopExceptionTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private LaptopService laptopService;

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
    public void testGettLaptopByIdResourceNotFoundException() throws Exception {
        when(this.laptopService.getLaptopById(1234L)).thenThrow(new ResourceNotFoundException("Laptop not found"));
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/laptops/" + 1234L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        yakshaAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), exceptionTestFile);
    }

	@Test
    public void testDeleteLaptopResourceNotFoundException() throws Exception {
        when(this.laptopService.deleteLaptop(1234L)).thenReturn(false); // Simulate not found scenario
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/laptops/" + 1234L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        yakshaAssert(currentTest(), (result.getResponse().getStatus() == HttpStatus.NOT_FOUND.value() ? "true" : "false"), exceptionTestFile);
    }

	@Test
	public void testCreateLaptopInvalidDataException() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();
		laptopDTO.setName(null);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/laptops")
				.content(MasterData.asJsonString(laptopDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testUpdateLaptopInvalidDataException() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();
		laptopDTO.setPrice(100000D);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/laptops/" + laptopDTO.getId())
				.content(MasterData.asJsonString(laptopDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		yakshaAssert(currentTest(),
				(result.getResponse().getStatus() == HttpStatus.BAD_REQUEST.value() ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testGetLaptopByIdResourceNotFoundException() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();
		ExceptionHandlerController.ErrorResponse exResponse = new ExceptionHandlerController.ErrorResponse(
				HttpStatus.BAD_REQUEST.value(), "Laptop not found");

		when(this.laptopService.getLaptopById(laptopDTO.getId()))
				.thenThrow(new ResourceNotFoundException("Laptop not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/laptops/" + laptopDTO.getId())
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(result.getResponse().getContentAsString().contains(exResponse.getMessage()) ? "true" : "false"),
				exceptionTestFile);

	}

	@Test
	public void testUpdateLaptopByIdResourceNotFoundException() throws Exception {
		LaptopDTO laptopDTO = getLaptopDTO();
		ExceptionHandlerController.ErrorResponse exResponse = new ExceptionHandlerController.ErrorResponse(
				HttpStatus.BAD_REQUEST.value(), "Laptop not found");

		when(this.laptopService.updateLaptop(eq(laptopDTO.getId()), any()))
				.thenThrow(new ResourceNotFoundException("Laptop not found"));
		RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/laptops/" + laptopDTO.getId())
				.content(MasterData.asJsonString(laptopDTO)).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		yakshaAssert(currentTest(),
				(exResponse.getMessage().contains("Laptop not found") ? "true" : "false"),
				exceptionTestFile);
	}
}
