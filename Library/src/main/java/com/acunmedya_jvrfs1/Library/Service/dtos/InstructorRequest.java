package com.acunmedya_jvrfs1.Library.Service.dtos;

import lombok.Data;

@Data
public class InstructorRequest {
    private String username;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private int nationalIdentity;
    private String email;
    private String password;
    private String companyName;
} 