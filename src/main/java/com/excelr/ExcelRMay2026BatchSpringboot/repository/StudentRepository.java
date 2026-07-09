package com.excelr.ExcelRMay2026BatchSpringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//	@Query(nativeQuery = true,value = "select * from student where department like ?1")
//	public List<Student> getDeptWiseStudent(String dname);
	
	public List<Student> findByDepartment(String dname);

//	@Query(nativeQuery = true,value = "select * from student where gender like ?1")
//	public List<Student> getStudentsByGender(String gender);
	
	public List<Student> findByGender(String dname);
	
	@Query(nativeQuery = true,value = "select distinct department from student")
	public List<String> getDistinctByDepartment();
	
	public List<Student> findByPerGreaterThan(double p);
}


//https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html