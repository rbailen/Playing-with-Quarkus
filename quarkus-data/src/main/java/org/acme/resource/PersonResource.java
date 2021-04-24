package org.acme.resource;

import io.smallrye.common.constraint.NotNull;
import org.acme.model.Person;
import org.acme.repository.PersonRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/persons")
public class PersonResource {

    @Inject
    PersonRepository personRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersons (){
        return personRepository.getPersons();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson (@PathParam("id") Long id){
        return personRepository.getPerson(id);
    }

    @GET
    @Path("{name}/{age}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByNameAndAge (@PathParam("name") String name, @PathParam("age") Integer age){
        return personRepository.getPersonByNameAndAge(name, age);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPerson(Person person) {
        Person created = personRepository.create(person);
        return Response.created(URI.create("/person/" + created.getId())).build();
    }
}