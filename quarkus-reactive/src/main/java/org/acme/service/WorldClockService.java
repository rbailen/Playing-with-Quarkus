package org.acme.service;

import org.acme.domain.WorldClock;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@Path("/api")
@RegisterRestClient
public interface WorldClockService {

    @GET
    @Path("/json/{where}/now")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<WorldClock> getNow(@PathParam("where") String where);
}