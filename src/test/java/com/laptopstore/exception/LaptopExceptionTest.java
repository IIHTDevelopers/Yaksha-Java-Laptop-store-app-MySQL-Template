package com.laptopstore.exception;

import static com.laptopstore.utils.TestUtils.currentTest;
import static com.laptopstore.utils.TestUtils.exceptionTestFile;
import static com.laptopstore.utils.TestUtils.testReport;
import static com.laptopstore.utils.TestUtils.yakshaAssert;
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
import com.laptopstore.service.LaptopService;

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
    public void testGetLaptopByIdResourceNotFoundException() throws Exception {
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
}
