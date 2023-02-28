package webapp.jaxws.services;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import webapp.jaxws.models.Course;

import java.util.Arrays;
import java.util.List;
@WebService(endpointInterface = "webapp.jaxws.services.WsService")
public class WsServiceImpl implements WsService{

    private int count;
    @WebMethod
    @Override
    public String greet(String person) {
        count++;
        System.out.println("count in greet method="+count);
        return "Hello mr ".concat(person).concat(" have a good day.");
    }
    @WebMethod
    @Override
    public List<Course> findAll() {
        return Arrays.asList(new Course("math"),new Course("lang")
        ,new Course("english"));
    }

    @Override
    @WebMethod
    public Course create(Course course) {
        Course c= new Course();
        c.setName(course.getName());
        return c;
    }
}
