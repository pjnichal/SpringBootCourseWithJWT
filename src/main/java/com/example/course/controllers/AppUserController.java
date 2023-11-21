package com.example.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.example.course.entity.AppUser;
import com.example.course.services.AppUserService;

@RestController
@RequestMapping("/api")
public class AppUserController {
    @Autowired
    private AppUserService appUserService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<AppUser>> getUsers() {

        List<AppUser> appUsers = appUserService.getAllUsers();
        return ResponseEntity.ok().body(appUsers);
    }

}
