package com.excelr.ExcelRMay2026BatchSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
