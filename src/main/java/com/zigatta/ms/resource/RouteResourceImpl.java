/**
 * 
 */
package com.zigatta.ms.resource;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zigatta.ms.constants.RouteConstants;
import com.zigatta.ms.exception.InvalidInputException;
import com.zigatta.ms.helper.RouteHelper;
import com.zigatta.ms.validator.RequestValidator;

/**
 * @author dipak
 *
 */
@Controller
public class RouteResourceImpl implements RouteResource {
	private static final Logger log = LoggerFactory.getLogger(RouteResourceImpl.class);
	
	@Autowired
	private RouteHelper routeHelper;
	
	
	@Override
	public Response connection(String origin, String destination) throws IOException, URISyntaxException {
		log.info("RouteResourceImpl.connection - request received.");
		/** request valid check ****/
		RequestValidator validator = new RequestValidator();
		if(!validator.isValidCity(origin)
				|| !validator.isValidCity(destination)){
			log.error("Invalid request received. origin = {}, destination = {}",origin,destination);
			throw new InvalidInputException(RouteConstants.HTTP_STATUS_CODE_BAD_REQUEST,RouteConstants.INVALID_INPUT_ERROR);
		}
		/** request valid check ****/
		
		if(origin.trim().equalsIgnoreCase(destination.trim())
				|| routeHelper.isConnectionExists(origin, destination))
			return Response.status(200).entity(RouteConstants.ROUTE_FOUND).type(MediaType.TEXT_PLAIN).build();
		else
			return Response.status(200).entity(RouteConstants.ROUTE_NOT_FOUND).type(MediaType.TEXT_PLAIN).build();
	}

}
