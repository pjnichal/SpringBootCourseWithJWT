package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.AppRole;

public interface RoleRepo extends JpaRepository<AppRole, Long> {
    AppRole findByName(String name);

}
