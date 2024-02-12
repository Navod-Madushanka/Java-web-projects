package com.navod.springboot.learnjpaandhibernate.controller;

import com.navod.springboot.learnjpaandhibernate.entity.Course;
import com.navod.springboot.learnjpaandhibernate.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class courseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/save-data")
    public void saveCourse(){
        Course course = new Course();
        course.setName("Python");
        course.setAuthor("Madushanka");
        courseRepository.save(course);
    }
    @GetMapping("/get-all")
    public void getAllCourses(){
        List<Course> courses = courseRepository.findAll();
        courses.forEach(course ->{
            System.out.println(course.toString());
        });
    }
}
