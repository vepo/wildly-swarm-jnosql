package com.example.demo.rest;

import com.example.demo.database.UserRepository;

import javax.inject.Inject;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@Inject
	private UserRepository userRepository;

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Find first: " + userRepository.existsById("not-found")).build();
	}
}
