package com.excelr.ExcelRMay2026BatchSpringboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class Student {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		@Column(name="rollnumber")
		private int rno;
		
//		@Column(name="studentname")
		private String sname;
		
//		@Column(name="percentage")
		private double per;
		
		@Transient  //will exclude it from being added to the db table
		private double temp;
		
		static private String collegeName="Kendra Vidyalay"; //exclude
		
		public Student() {}
		public Student(int rno, String sname, double per) {
			this.rno = rno;
			this.sname = sname;
			this.per = per;
		}
		public int getRno() {
			return rno;
		}
		public void setRno(int rno) {
			this.rno = rno;
		}
		public String getSname() {
			return sname;
		}
		public void setSname(String sname) {
			this.sname = sname;
		}
		public double getPer() {
			return per;
		}
		public void setPer(double per) {
			this.per = per;
		}
		@Override
		public String toString() {
			return "Student [rno=" + rno + ", sname=" + sname + ", per=" + per + "]";
		}
		
}
