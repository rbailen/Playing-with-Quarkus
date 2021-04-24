package org.acme.service;

import org.acme.domain.WorldClock;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
@RegisterRestClient
public interface WorldClockService {

    @GET @Path("/json/est/now")
    @Produces(MediaType.APPLICATION_JSON)
    //@ClientHeaderParam(name = "X-Logger", value = "DEBUG")
    WorldClock getNow();
}
