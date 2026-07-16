package com.excelr.ExcelRMay2026BatchSpringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.DBUser;

@Repository
public interface DBUserRepository extends JpaRepository<DBUser, Integer>{
		public DBUser findByUsername(String s);
}
