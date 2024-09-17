package com.school.SchoolAPI.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateStudentDto {

    @NotNull(message = "name shouldn't be null")
    private String name;
    @NotBlank
    private String regNo;
    @Min(1)
    @Max(5)
    private Integer yearOfStudy;
    private String gender;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
    private String mobileNumber;
}
