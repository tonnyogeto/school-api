package com.school.SchoolAPI.service;

import com.school.SchoolAPI.dao.StudentDao;
import com.school.SchoolAPI.dto.CreateStudentDto;
import com.school.SchoolAPI.dto.FetchStudentDto;
import com.school.SchoolAPI.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;


    public List<FetchStudentDto> getAllStudents() {
        List<Student> allStudents =studentDao.findAll();
        List<FetchStudentDto> dtos = new ArrayList<>();

        for(Student s : allStudents){
            FetchStudentDto dto =convertToDto(s);
            dtos.add(dto);
        }
        return dtos;
    }

    public static FetchStudentDto convertToDto(Student student){
        FetchStudentDto dto = new FetchStudentDto();
        dto.setName(student.getName());
        dto.setRegNo(student.getRegNo());
        dto.setYearOfStudy(student.getYearOfStudy());

        return dto;
    }

    @Transactional
    public void createStudent(CreateStudentDto dto) {
        Student student = new Student();

        student.setName(dto.getName());
        student.setRegNo(dto.getRegNo());
        student.setGender(dto.getGender());
        student.setMobileNumber(dto.getMobileNumber());
        student.setYearOfStudy(dto.getYearOfStudy());

        studentDao.save(student);
    }
}
