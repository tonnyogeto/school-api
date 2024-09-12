package com.school.SchoolAPI.dto;

import lombok.Data;

@Data
public class CreateStudentDto {
    private String name;
    private String regNo;
    private Integer yearOfStudy;
    private String gender;
    private String mobileNumber;
}
