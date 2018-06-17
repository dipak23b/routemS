package com.zigatta.ms.config;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.zigatta.ms.constants.RouteConstants;
import com.zigatta.ms.exception.InvalidInputException;

@Provider
public class InvalidRequestExceptionMapper implements ExceptionMapper<InvalidInputException> {

	@Override
	public Response toResponse(InvalidInputException exception) {
		return Response.status(exception.getHttpCode())
				.entity(RouteConstants.ROUTE_NOT_FOUND).type(MediaType.TEXT_PLAIN).build();
	}

}
