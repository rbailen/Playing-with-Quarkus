package org.acme.resource;

import org.acme.domain.WorldClock;
import org.acme.service.WorldClockService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

@Path("/worldclock")
public class WorldClockResource {

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public WorldClock getNow() {
        return ClientBuilder.newClient()
                .target("http://worldclockapi.com")
                .path("/api/json/est/now")
                .request()
                .get(WorldClock.class);
        //return worldClockService.getNow();
    }
}