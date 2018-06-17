package com.zigatta.ms.validator;

import org.mockito.InjectMocks;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class RequestValidatorTest {

	private RequestValidator requestValidator;
	
	@Test
	public void validCityTest(){
		requestValidator = new RequestValidator();
		assertTrue(requestValidator.isValidCity("Boston"));
		assertFalse(requestValidator.isValidCity(""));
		assertFalse(requestValidator.isValidCity(null));
		assertFalse(requestValidator.isValidCity("  "));
	}
	
}
