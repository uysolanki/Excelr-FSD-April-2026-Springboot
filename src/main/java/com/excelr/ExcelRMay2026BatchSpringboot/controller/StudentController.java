package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Student;
import com.excelr.ExcelRMay2026BatchSpringboot.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/save-student")  //endpoint
	public String saveStudent()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		studentService.saveStudent(s1);
		return "Record Inserted Successfully";
	}

	
}
