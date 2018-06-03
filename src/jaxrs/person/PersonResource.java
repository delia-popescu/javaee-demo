package jaxrs.person;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("persons")
public class PersonResource {

    @EJB
    Database database;

    @GET
    @Produces({ "application/xml", "application/json" })
    public List<Person> getList() {
       return database.getAll();
    }

    @GET
    @Path("{pid}")
    @Produces({ "application/xml", "application/json" })
    public Response getById(@PathParam("pid") int id) {
        Person person = database.getById(id);
        if(person == null){
            throw new PersonNotFoundException(id);
        }
        return Response.ok().entity(person).build();
    }

    @POST
    @Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(@FormParam("name") String name, @FormParam("age") int age){
        Person person = new Person(database.getAll().size() + 1 , name, age);
        database.add(person);
        return Response.created(UriBuilder.fromPath("persons/{pid}").build(person.getId())).entity(person).build();
    }

    @PUT
    @Path("{pid}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Person updatePerson(@PathParam("pid") int id, Person newPerson){
        Person person = database.getById(id);
        person.setName(newPerson.getName());
        person.setAge(newPerson.getAge());
        database.updateById(id, person);
        return person;
    }

    @DELETE
    @Path("{pid}")
    @Produces("application/json")
    public void deletePerson(@PathParam("pid") int id){
        database.deleteById(id);
    }
}