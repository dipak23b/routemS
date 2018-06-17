package com.zigatta.ms.resource;

import java.io.IOException;
import java.net.URISyntaxException;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/connected")
@Produces(MediaType.TEXT_PLAIN)
public interface RouteResource {
	@GET
	@Path("/")
	public Response connection(@QueryParam("origin") String origin,
								@QueryParam("destination") String destination) throws IOException, URISyntaxException;
}
