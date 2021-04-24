package org.acme.resource;

import org.acme.service.ExpensiveService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/expensive")
public class ExpensiveResource {

    @Inject
    ExpensiveService expensiveService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public int calculate() {
        return expensiveService.calculate();
    }
}
