package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/test")
	public String test()
	{
		return "This is my first springboot";
	}
}
