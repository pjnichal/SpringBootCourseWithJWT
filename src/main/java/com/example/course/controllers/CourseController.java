package com.example.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entity.Course;
import com.example.course.services.CourseService;
import java.util.List;

@RestController()
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    // create
    @PostMapping("/save")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    // update
    @PatchMapping("/update")
    public Course saveUpdate(@RequestBody Course course) {
        return courseService.updatCourse(course);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public Boolean deleteCourse(@PathVariable int id) {
        System.out.println("id equals to " + id);
        try {
            courseService.delCourse(id);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }

        return true;
    }

    // read
    @GetMapping("/getAll")
    public List<Course> getAllCourse() {
        return courseService.getAll();
    }

}
