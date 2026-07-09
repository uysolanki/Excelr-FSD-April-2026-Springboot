package com.excelr.ExcelRMay2026BatchSpringboot.service;

import java.util.List;

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

	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	public List<Student> saveMultipleStudent(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	public Student getSingleStudent(int rollno) {
		Student studFromDb=studentRepository.findById(rollno).orElse(null);
		return studFromDb;
	}

	public List<Student> getStudentsByDepartment(String deptName) {
//		return studentRepository.getDeptWiseStudent(deptName);
		return studentRepository.findByDepartment(deptName);
	}

	public List<Student> getStudentsByGender(String gender) {
//		return studentRepository.getStudentsByGender(gender);
		return studentRepository.findByGender(gender);
	}

	public List<String> getAllDepartmentNames() {
		return studentRepository.getDistinctByDepartment();
	}
	
	public List<String> getAllDepartmentNames1() {
		List<Student> students=getAllStudents();
		return students.stream()
		.map(Student::getDepartment)
		.distinct()
		.toList();
	}

	public List<Student> getStudentsGreaterThanCertainPercentage(double basePercentage) {
		return studentRepository.findByPerGreaterThan(basePercentage);
	}
}
