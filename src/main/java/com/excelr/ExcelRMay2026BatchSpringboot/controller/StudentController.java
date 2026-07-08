package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping("/save-student1")  //endpoint
	public Student saveStudent1()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	
	@RequestMapping("/save-student-using-request-param")  //endpoint
	public Student saveStudentUsingRequestParam(@RequestParam("a") double percent, @RequestParam("b") String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@RequestMapping("/save-student-using-request-param1")  //endpoint
	public Student saveStudentUsingRequestParam1(@RequestParam double percent, @RequestParam String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	
	@RequestMapping("/save-student-using-pathvariable/{a}/{b}")  //endpoint
	public Student saveStudentUsingPathVariable(@PathVariable("a") double percent, @PathVariable("b") String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@RequestMapping("/save-student-using-pathvariable1/{percent}/{studName}")  //endpoint
	public Student saveStudentUsingPathVariable1(@PathVariable double percent, @PathVariable String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	
	@RequestMapping("/save-student-using-requestbody")  //endpoint
	public Student saveStudentUsingRequestBody(@RequestBody Student s1)
	{
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}

	
}



/*
 To Accept input from user we have 3 ways
 1. @RequestParam
 2. @PathVariable
 3. @RequestBody
*/



/*
{
"rno": 11,
"sname": "Rahul",
"per": 80.8
}
*/