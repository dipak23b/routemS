package com.zigatta.ms.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zigatta.ms.request.filter.InputRequestFilter;
import com.zigatta.ms.resource.RouteResourceImpl;
import com.zigatta.ms.response.filter.ResponseInfoFilter;

@Component
@ApplicationPath("/")
public class JerseyConfiguration extends ResourceConfig {
	
	@Bean
	@Primary
	public ObjectMapper objectMapper(){
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		objectMapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES);
		return objectMapper;
	}
	
	
	@Autowired
	public JerseyConfiguration(){
		register(RouteResourceImpl.class);
		register(InvalidRequestExceptionMapper.class);
		register(ApplicationExceptionMapper.class);
		register(InputRequestFilter.class);
		register(ResponseInfoFilter.class);
	}	
}
