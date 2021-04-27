package org.acme.resource;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/producers")
public class ProducerResource {

    @Inject
    @Channel("in-memory")
    Emitter<Integer> emitter;

    @GET
    @Path("{number}")
    public void emit(@PathParam("number") Integer number){
        emitter.send(number);
    }
}
