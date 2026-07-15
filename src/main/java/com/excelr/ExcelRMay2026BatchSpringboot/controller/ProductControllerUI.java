package com.excelr.ExcelRMay2026BatchSpringboot.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.excelr.ExcelRMay2026BatchSpringboot.entity.Product;
import com.excelr.ExcelRMay2026BatchSpringboot.exception.ProductNotFoundException;
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
	
	@RequestMapping("/add-new-product-form")
	public String addNewProduct(Model model)
	{
	Product p1=new Product();
	model.addAttribute("product",p1);
	return "add-new-product-form";
	}
	
	@RequestMapping("/add-new-product-form2")
	public String addNewProduct1(Model model)
	{
	Product p1=new Product();
	model.addAttribute("product",p1);
	return "add-new-product-form2";
	}
	
	@PostMapping("/addSingleProduct")
	public String saveProduct(@ModelAttribute Product product)
	{
		productService.saveProduct(product);
		return "redirect:/show-all-products";
	}
	
	@RequestMapping("/deleteProductUI/{pid}")
	public String deleteProductUI(@PathVariable int pid)
	{
	productService.deleteProduct(pid);
	return "redirect:/show-all-products";
	}
	
	
	@PostMapping("/addSingleProduct1")
	public String saveProduct1(@ModelAttribute Product product, @RequestParam("imageFile") MultipartFile file) throws IOException
	{
		
		if (!file.isEmpty()) {

	        String uploadDir = "uploads/";
	        Files.createDirectories(Paths.get(uploadDir));

	        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
	        Path filePath = Paths.get(uploadDir, fileName);

	        Files.write(filePath, file.getBytes());

	        // Save only filename or relative path
	        product.setImage("http://localhost:8090/uploads/" + fileName);
	    }
		productService.saveProduct(product);
		return "redirect:/show-all-products";
	}
	
	@RequestMapping("/updateProductFormFE/{pid}")
	public String updateProductUI(@PathVariable int pid, Model model)
	{
	Product product=productService.getSingleProduct(pid);
	model.addAttribute("product",product);
	return "update-product-form";
	}
	
	
	@PostMapping("/updateProductFE/{prodId}")
	public String updateProductUI(@PathVariable int prodId, @ModelAttribute Product product)
	{
	productService.updateProduct(prodId, product);
	return "redirect:/show-all-products";
	}
}
