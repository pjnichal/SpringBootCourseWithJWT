package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.course.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    AppUser findByEmail(String email);

}
