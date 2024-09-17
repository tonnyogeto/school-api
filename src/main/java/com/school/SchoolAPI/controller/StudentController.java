package com.school.SchoolAPI.controller;

import com.school.SchoolAPI.dto.CreateStudentDto;
import com.school.SchoolAPI.dto.FetchStudentDto;
import com.school.SchoolAPI.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public ResponseEntity<?> getAllStudents(){
        List<FetchStudentDto> students =studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping()
    public ResponseEntity<?> createStudent(
            @RequestBody @Valid CreateStudentDto dto
    ){
        studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("success");
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<?> getStudentById(
            @PathVariable("studentId") Integer studentId
    ){
        FetchStudentDto student =studentService.getStudentById(studentId);
        return ResponseEntity.status(HttpStatus.OK).body(student);

    }
}

