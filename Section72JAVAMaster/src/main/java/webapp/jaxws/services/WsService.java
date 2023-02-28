package webapp.jaxws.services;

import jakarta.jws.WebService;
import webapp.jaxws.models.Course;

import java.util.List;

@WebService
public interface WsService {


    String greet(String person);
    List<Course> findAll();
    Course create(Course course);


}
