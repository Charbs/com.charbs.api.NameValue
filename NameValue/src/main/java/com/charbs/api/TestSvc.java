package com.charbs.api;
 
import java.util.List;
 
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// thought I remove annotations?

@Stateless
@LocalBean
@Path("/nameValue")
public class TestSvc {
 
    @PersistenceContext(unitName="TestSvc",
                        type=PersistenceContextType.TRANSACTION)
    EntityManager entityManager;
 
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public void create(NameValue nameValue) {
        entityManager.persist(nameValue);
    }
 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("{id}")
    public NameValue read(@PathParam("id") long id) {
        return entityManager.find(NameValue.class, id);
    }
 
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void update(NameValue nameValue) {
        entityManager.merge(nameValue);
    }
 
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") long id) {
        NameValue nameValue = read(id);
        if(null != nameValue) {
            entityManager.remove(nameValue);
        }
    }
 
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("findValue/{name}")
    public List<NameValue> findValue(@PathParam("name") String name) {
        Query query = entityManager.createNamedQuery("findValue");
        query.setParameter("name", name);
        return query.getResultList();
    }
 
}