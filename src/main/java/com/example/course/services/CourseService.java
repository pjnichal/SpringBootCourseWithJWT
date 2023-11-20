package com.example.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.course.entity.Course;
import com.example.course.repository.CourseRepo;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepo courseRepo;

    // Save
    public Course saveCourse(Course course) {
        return courseRepo.save(course);

    }

    // Get
    public List<Course> getAll() {
        return courseRepo.findAll();
    }

    public Course getCourseById(int id) {
        return courseRepo.findById(id).orElse(null);
    }

    // Update
    public Course updatCourse(Course course) {
        return courseRepo.save(course);
    }

    // Delete
    public void delCourse(int id) {
        courseRepo.deleteById(id);

    }
}
