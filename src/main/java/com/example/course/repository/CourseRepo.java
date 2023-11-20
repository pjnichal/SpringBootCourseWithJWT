package com.example.course.repository;

import com.example.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course, Integer> {
}
