package com.example.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import com.example.course.entity.AppUser;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);

}
