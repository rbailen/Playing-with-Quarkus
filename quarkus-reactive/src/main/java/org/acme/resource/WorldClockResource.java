package org.acme.resource;

import org.acme.domain.WorldClock;
import org.acme.service.WorldClockService;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletionStage;

@Path("/worldclock")
public class WorldClockResource {

    @Inject
    @RestClient
    WorldClockService worldClockService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<List<WorldClock>> getNow() {
        CompletionStage<WorldClock> cet = worldClockService.getNow("cet");
        return cet.thenCombineAsync(
                worldClockService.getNow("gmt"),
                (cetResult, gmtResult) -> Arrays.asList(cetResult, gmtResult)
        );
    }
}
