package lt.vu.rest;

import lt.vu.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestService {

    @Inject private EntityManager em;

    @GET
    @Path("/{studentId}")
    public Student find(@PathParam("studentId") Integer studentId) {
        return em.find(Student.class, studentId);
    }

    @POST
    @Path("/create")
    @Transactional
    public Student create(@DefaultValue("Name")@QueryParam("Firstname") String name,
                          @DefaultValue("LastName") @QueryParam("Lastname") String lastName,
                          @DefaultValue("123")@QueryParam("RegNo") String regNo) {
        Student student = new Student();
        student.setFirstName(name);
        student.setLastName(lastName);
        student.setRegistrationNo(regNo);
        em.persist(student);
        return student;
    }

    @Path("/update/{id}")
    @PUT
    @Transactional
    public Student update(@PathParam("id") Integer id,
                           @QueryParam("Name") String name,
                           @QueryParam("LastName") String lastName,
                           @QueryParam("RegNr") String regNr) {
        Student student = em.find(Student.class, id);
        if (student == null) {
            throw new IllegalArgumentException("student id "
                    + id + " not found");
        }
        student.setFirstName(name);
        student.setLastName(lastName);
        student.setRegistrationNo(regNr);
        em.merge(student);
        return student;
    }
}
