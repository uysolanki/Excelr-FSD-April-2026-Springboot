package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Product;
import com.excelr.ExcelRMay2026BatchSpringboot.service.ProductService;

@Controller
public class ProductControllerUI {

	@Autowired
	ProductService productService;
	
	
	@RequestMapping("/show-all-products")
	public String showAllProducts(Model model)
	{
		List<Product> products=productService.getAllProducts();
		model.addAttribute("products",products);
		return "show-all-products";
	}
}
