package com.example.course.entity;

import java.util.ArrayList;
import java.util.Collection;
import com.example.course.entity.AppRole;
public class AppUser {
    private Long id;
    private String name;
    private String email;
    private String passsword;
    private Collection<AppRole> roles = new ArrayList<>();

}
