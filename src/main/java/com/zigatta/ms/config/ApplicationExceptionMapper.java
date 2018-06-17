package com.zigatta.ms.config;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.zigatta.ms.constants.RouteConstants;

@Provider
public class ApplicationExceptionMapper implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		return Response.status(RouteConstants.HTTP_STATUS_CODE_INTERNAL_SERVER_ERROR)
				.entity(RouteConstants.ROUTE_NOT_FOUND).type(MediaType.TEXT_PLAIN).build();
	}

}
