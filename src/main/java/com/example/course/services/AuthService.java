package com.example.course.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.course.entity.AppUser;
import com.example.course.utils.AuthenticationRequest;
import com.example.course.utils.AuthenticationResponse;
import com.example.course.utils.RegisterRequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    private AppUserService appUserService;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        AppUser appuser = new AppUser();
        appuser.setName(request.getName());
        appuser.setEmail(request.getEmail());
        appuser.setPassword(passwordEncoder.encode(request.getPassword()));
        appUserService.saveAppUser(appuser);
        appUserService.addRoleToUser(appuser.getEmail(), request.getRole());
        var jwtToken = jwtService.generateToken(appuser);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        AppUser appUser = appUserService.getUser(request.getEmail());

        var jwtToken = jwtService.generateToken(appUser);
        return new AuthenticationResponse(jwtToken);
    }

}
