package com.excelr.ExcelRMay2026BatchSpringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Student;
import com.excelr.ExcelRMay2026BatchSpringboot.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;  //Hibernate session

	public Student saveStudent(Student s1) {
		return studentRepository.save(s1);
		
	}
}
