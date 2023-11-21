package com.example.course.services;

import com.example.course.entity.AppRole;
import com.example.course.entity.AppUser;
import com.example.course.repository.AppUserRepo;
import com.example.course.repository.RoleRepo;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppUserService
 */
@Service
@Transactional
@Slf4j
public class AppUserService {
    @Autowired
    private AppUserRepo appUserRepo;
    @Autowired
    private RoleRepo roleRepo;

    public AppUser saveAppUser(AppUser appUser) {
        log.info("save user");
        return appUserRepo.save(appUser);
    }

    public AppRole saveAppRole(AppRole appRole) {
        log.info("save role");
        return roleRepo.save(appRole);

    }

    public void addRoleToUser(String email, String rolename) {
        log.info("save role to user");
        AppUser user = appUserRepo.findByEmail(email);
        AppRole appRole = roleRepo.findByName(rolename);
        user.getRoles().add(appRole);

    }

    public AppUser getUser(String email) {
        log.info("get user");
        return appUserRepo.findByEmail(email);
    }

    public List<AppUser> getAllUsers() {
        log.info("get all user");
        return appUserRepo.findAll();
    }
}