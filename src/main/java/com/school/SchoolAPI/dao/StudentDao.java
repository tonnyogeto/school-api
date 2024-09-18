package com.school.SchoolAPI.dao;

import com.school.SchoolAPI.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Integer> {

}
