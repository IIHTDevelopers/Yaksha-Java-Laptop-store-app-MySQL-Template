package com.laptopstore.boundary;

import static com.laptopstore.utils.TestUtils.boundaryTestFile;
import static com.laptopstore.utils.TestUtils.currentTest;
import static com.laptopstore.utils.TestUtils.testReport;
import static com.laptopstore.utils.TestUtils.yakshaAssert;

import java.io.IOException;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.laptopstore.dto.LaptopDTO;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class BoundaryTest {

	private static Validator validator;

	@BeforeAll
	public static void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@AfterAll
	public static void afterAll() {
		testReport();
	}

	@Test
	public void testNameNotBlank() throws IOException {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setName("");
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testNameMinThree() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setName("qw");
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testNameNotNull() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setName(null);
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testPricePositive() throws IOException {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setPrice(-1.0); // Negative value to trigger the @Positive constraint
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testPriceNotNull() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setPrice(null);
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testBrandNotBlank() throws IOException {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setBrand(""); // Blank to trigger the @NotBlank constraint
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testBrandMinThree() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setBrand("qw");
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testBrandNotNull() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setBrand(null);
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testStorageNotBlank() throws IOException {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setStorage(""); // Blank to trigger the @NotBlank constraint
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testStorageMinThree() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setStorage("qw");
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testStorageNotNull() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setStorage(null);
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testRamNotBlank() throws IOException {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setRam(""); // Blank to trigger the @NotBlank constraint
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testRamNotNull() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setRam(null);
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProcessorNotBlank() throws IOException {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setProcessor(""); // Blank to trigger the @NotBlank constraint
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		try {
			yakshaAssert(currentTest(), !violations.isEmpty(), boundaryTestFile);
		} catch (Exception e) {
			yakshaAssert(currentTest(), false, boundaryTestFile);
		}
	}

	@Test
	public void testProcessorMinThree() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setProcessor("qw");
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}

	@Test
	public void testProcessorNotNull() throws Exception {
		LaptopDTO laptopDTO = new LaptopDTO();
		laptopDTO.setProcessor(null);
		Set<ConstraintViolation<LaptopDTO>> violations = validator.validate(laptopDTO);
		yakshaAssert(currentTest(), !violations.isEmpty() ? true : false, boundaryTestFile);
	}
}
