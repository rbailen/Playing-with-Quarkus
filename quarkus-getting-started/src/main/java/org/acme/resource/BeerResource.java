package org.acme.resource;

import org.acme.domain.Beer;
import org.jboss.logging.Logger;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/beer")
public class BeerResource {

    Logger logger = Logger.getLogger(BeerResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Beer getBeer() {
        logger.debug("Get Beer");
        return new Beer("Alhambra", 300);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createBeer(@Valid Beer beer) {
        System.out.println("Beer: " + beer);
        return Response.ok().build();
    }
}