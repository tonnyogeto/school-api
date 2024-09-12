package com.school.SchoolAPI.dto;

import lombok.Data;

@Data
public class FetchStudentDto {
    private String name;
    private String regNo;
    private Integer yearOfStudy;
}
