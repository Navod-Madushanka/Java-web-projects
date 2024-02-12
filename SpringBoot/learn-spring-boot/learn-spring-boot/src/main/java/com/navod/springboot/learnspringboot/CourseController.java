package com.navod.springboot.learnspringboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1L, "Learn AWS", "Hasitha"),
                new Course(2L, "Learn DevOps", "Navod"),
                new Course(3L, "Learn Azure", "Madushanka"),
                new Course(4L, "Learn Hibernate", "Maithripala")
        );
    }
}
