package com.example.course.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import com.example.course.entity.AppRole;
import com.example.course.entity.AppUser;
import com.example.course.services.AppUserService;
import com.example.course.services.AuthService;
import com.example.course.utils.AuthenticationRequest;
import com.example.course.utils.AuthenticationResponse;
import com.example.course.utils.RegisterRequest;

import lombok.Data;

@RestController
@RequestMapping("/api")
public class AppUserController {
    @Autowired
    private AuthService authService;
    @Autowired
    private AppUserService appUserService;

    @PostMapping("/auth/signUp")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<AuthenticationResponse> auth(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/users/getAllUsers")
    public ResponseEntity<List<AppUser>> getUsers() {

        List<AppUser> appUsers = appUserService.getAllUsers();
        return ResponseEntity.ok().body(appUsers);
    }

    @GetMapping("/users")
    public ResponseEntity<String> getUser() {

        return ResponseEntity.ok().body("MOYE MOYE");
    }

    @PostMapping("/users/saveUser")
    public ResponseEntity<AppUser> saveUser(@RequestBody AppUser appUser) {
        URI uri = URI
                .create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/saveUser").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveAppUser(appUser));
    }

    @PostMapping("/roles/saveRole")
    public ResponseEntity<AppRole> saveRole(@RequestBody AppRole appRole) {
        URI uri = URI
                .create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/saveRole").toUriString());
        return ResponseEntity.created(uri).body(appUserService.saveAppRole(appRole));
    }

}

@Data
class RoleToUserForm {
    private String email;
    private String roleName;
}