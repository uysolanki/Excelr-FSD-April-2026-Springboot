package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Student;
import com.excelr.ExcelRMay2026BatchSpringboot.exception.StudentNotFoundException;
import com.excelr.ExcelRMay2026BatchSpringboot.service.StudentService;

@RestController //to return raw JSON data
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/save-student")  //endpoint
	public String saveStudent()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		studentService.saveStudent(s1);
		return "Record Inserted Successfully";
	}
	
	
	@PostMapping("/save-studentRE")  //endpoint
	public ResponseEntity<String> saveStudentRE()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		studentService.saveStudent(s1);
		return new ResponseEntity<String>("Record Inserted Successfully", HttpStatus.CREATED);  //201
	}
	
	@PostMapping("/save-student1")  //endpoint
	public Student saveStudent1()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student1RE")  //endpoint
	public ResponseEntity<Student> saveStudent1RE()
	{
		Student s1=new Student();
		s1.setPer(78.5);
		s1.setSname("Alice");
		
		Student savedStudent=studentService.saveStudent(s1);
		return new ResponseEntity<Student>(savedStudent, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/save-student-using-request-param")  //endpoint
	public Student saveStudentUsingRequestParam(@RequestParam("a") double percent, @RequestParam("b") String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student-using-request-param1")  //endpoint
	public Student saveStudentUsingRequestParam1(@RequestParam double percent, @RequestParam String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	
	@PostMapping("/save-student-using-pathvariable/{a}/{b}")  //endpoint
	public Student saveStudentUsingPathVariable(@PathVariable("a") double percent, @PathVariable("b") String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-student-using-pathvariable1/{percent}/{studName}")  //endpoint
	public Student saveStudentUsingPathVariable1(@PathVariable double percent, @PathVariable String studName)
	{
		Student s1=new Student();
		s1.setPer(percent);
		s1.setSname(studName);
		
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	
	@PostMapping("/save-student-using-requestbody")  //endpoint
	public Student saveStudentUsingRequestBody(@RequestBody Student s1)
	{
		Student savedStudent=studentService.saveStudent(s1);
		return savedStudent;
	}
	
	@PostMapping("/save-multiple-student-using-requestbody")  //endpoint
	public List<Student> saveMultipleStudentUsingRequestBody(@RequestBody List<Student> students)
	{
		List<Student> savedStudents=studentService.saveMultipleStudent(students);
		return savedStudents;
	}
	
	@PostMapping("/save-multiple-student-using-requestbody-re")  //endpoint
	public ResponseEntity<List<Student>> saveMultipleStudentUsingRequestBodyRe(@RequestBody List<Student> students)
	{
		List<Student> savedStudents=studentService.saveMultipleStudent(students);
		return new ResponseEntity<List<Student>>(savedStudents, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get-all-students")  //select
	public List<Student> getAllStudents()
	{
		List<Student> students=studentService.getAllStudents();
		return students;
	}
	
	@GetMapping("/get-all-students-re")  //select
	public ResponseEntity<List<Student>> getAllStudentsRe()
	{
		List<Student> students=studentService.getAllStudents();
		return new ResponseEntity<List<Student>>(students,HttpStatus.OK);   //200
	}
	
	@GetMapping("/get-single-student/{rollno}")  //select
	public Student getSingleStudent(@PathVariable int rollno)
	{
		Student student=studentService.getSingleStudent(rollno);
		return student;
	}
	
	
	@GetMapping("/get-students-by-department/{deptName}")  //select
	public List<Student> getStudentsByDepartment(@PathVariable String deptName)
	{
		List<Student> deptWiseStudents=studentService.getStudentsByDepartment(deptName);
		return deptWiseStudents;
	}
	
	
	@GetMapping("/get-students-by-gender/{gender}")  //select
	public List<Student> getStudentsByGender(@PathVariable String gender)
	{
		List<Student> genderWiseStudents=studentService.getStudentsByGender(gender);
		return genderWiseStudents;
	}
	
	@GetMapping("/get-all-department-names")  //select
	public List<String> getAllDepartmentNames()
	{
		List<String> departmentNames=studentService.getAllDepartmentNames1();
		return departmentNames;
	}
	
	@GetMapping("/get-students-greater-than-certain-percentage/{basePercentage}")  //select
	public List<Student> getStudentsGreaterThanCertainPercentage(@PathVariable double basePercentage)
	{
		List<Student> students=studentService.getStudentsGreaterThanCertainPercentage(basePercentage);
		return students;
	}
	
	@DeleteMapping("/delete-student/{rollnumber}")  //select
	public String deleteStudent(@PathVariable int rollnumber)
	{
		try
		{
		studentService.deleteStudent(rollnumber);
		return "Student Record Deleted";
		}
		catch(StudentNotFoundException ex1)
		{
			return ex1.getMessage();
		}
	}
	
	
	@DeleteMapping("/delete-student-re/{rollnumber}")  //select
	public ResponseEntity<String> deleteStudentRe(@PathVariable int rollnumber)
	{
		try
		{
		studentService.deleteStudent(rollnumber);
		return new ResponseEntity<String>("Student Record Deleted", HttpStatus.OK);
		}
		catch(StudentNotFoundException ex1)
		{
			return new ResponseEntity<String>(ex1.getMessage(), HttpStatus.NO_CONTENT);
		}
	}
	
	@PutMapping("/update-student/{rollnumber}")  //select
	public String updateStudent(@PathVariable int rollnumber, @RequestBody Student updatedValues)
	{
		try
		{
		studentService.updateStudent(rollnumber,updatedValues);
		return "Student Record Updated";
		}
		catch(StudentNotFoundException ex1)
		{
			return ex1.getMessage();
		}
	}
	
	@PutMapping("/update-student-re/{rollnumber}")  //select
	public ResponseEntity<String> updateStudentRe(@PathVariable int rollnumber, @RequestBody Student updatedValues)
	{
		try
		{
		studentService.updateStudent(rollnumber,updatedValues);
		return new ResponseEntity<String>("Student Record Updated", HttpStatus.OK);
		}
		catch(StudentNotFoundException ex1)
		{
			return new ResponseEntity<String>( ex1.getMessage(), HttpStatus.BAD_REQUEST);
		}
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



/*

[
  {
    "sname": "Aarav Sharma",
    "per": 91.5,
    "dob": "2002-05-15",
    "department": "Computer",
    "mobileNumber": 9876543210,
    "gender": "Male"
  },
  {
    "sname": "Priya Patil",
    "per": 88.2,
    "dob": "2001-08-22",
    "department": "Electronics",
    "mobileNumber": 9876543211,
    "gender": "Female"
  },
  {
    "sname": "Rahul Verma",
    "per": 76.8,
    "dob": "2003-02-10",
    "department": "Mechanical",
    "mobileNumber": 9876543212,
    "gender": "Male"
  },
  {
    "sname": "Sneha Kulkarni",
    "per": 94.1,
    "dob": "2002-11-05",
    "department": "Computer",
    "mobileNumber": 9876543213,
    "gender": "Female"
  },
  {
    "sname": "Rohan Mehta",
    "per": 69.7,
    "dob": "2001-09-18",
    "department": "Civil",
    "mobileNumber": 9876543214,
    "gender": "Male"
  },
  {
    "sname": "Ananya Deshmukh",
    "per": 85.4,
    "dob": "2002-07-30",
    "department": "IT",
    "mobileNumber": 9876543215,
    "gender": "Female"
  },
  {
    "sname": "Karan Singh",
    "per": 79.9,
    "dob": "2003-01-12",
    "department": "Electrical",
    "mobileNumber": 9876543216,
    "gender": "Male"
  },
  {
    "sname": "Neha Joshi",
    "per": 92.8,
    "dob": "2001-12-25",
    "department": "IT",
    "mobileNumber": 9876543217,
    "gender": "Female"
  },
  {
    "sname": "Vikram Nair",
    "per": 73.5,
    "dob": "2002-04-08",
    "department": "Computer",
    "mobileNumber": 9876543218,
    "gender": "Male"
  },
  {
    "sname": "Pooja Shah",
    "per": 89.6,
    "dob": "2003-06-14",
    "department": "Electronics",
    "mobileNumber": 9876543219,
    "gender": "Female"
  }
]
*/