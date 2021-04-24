package org.acme.resource;

import org.acme.model.Developer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/developers")
public class DeveloperResource {

    @Inject
    EntityManager entityManager;

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Developer getDeveloper (@PathParam("id") String id){
        return entityManager.find(Developer.class, id);
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        entityManager.persist(developer);
        return Response.created(URI.create("/developer/" + developer.getId())).build();
    }
}