package com.scholiq.Scholiq.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
    private Long teacherId;
    private Long subjectId;
    private String name;
    private int rollNum;

}
