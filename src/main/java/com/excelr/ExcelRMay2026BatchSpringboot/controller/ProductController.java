//package com.excelr.ExcelRMay2026BatchSpringboot.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.excelr.ExcelRMay2026BatchSpringboot.entity.Product;
//import com.excelr.ExcelRMay2026BatchSpringboot.exception.ProductNotFoundException;
//import com.excelr.ExcelRMay2026BatchSpringboot.service.ProductService;
//
//@RestController
//public class ProductController {
//
//	@Autowired
//	ProductService productService;
//	
//	@PostMapping("/save-product")
//	public ResponseEntity<Product> saveProduct(@RequestBody Product product)
//	{
//		Product savedProduct=productService.saveProduct(product);
//		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
//	}
//	
//	
//	@PostMapping("/save-products")
//	public ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> products)
//	{
//		return new ResponseEntity<List<Product>>(productService.saveProducts(products),HttpStatus.CREATED);
//	}
//	
//	
//	@GetMapping("/get-all-products")
//	public ResponseEntity<List<Product>> getAllProducts()
//	{
//		return new ResponseEntity<List<Product>>(productService. getAllProducts(),HttpStatus.OK);
//	}
//	
//	
//	@GetMapping("/get-single-product/{prodid}")
//	public ResponseEntity<Product> getSingleProduct(@PathVariable int prodid)
//	{
//		return new ResponseEntity<Product>(productService.getSingleProduct(prodid),HttpStatus.OK);
//	}
//	
//	@DeleteMapping("/delete-product/{prodid}")
//	public ResponseEntity<String> deleteProduct(@PathVariable int prodid)
//	{
//		try
//		{
//		productService.deleteProduct(prodid);
//		return new ResponseEntity<String>("Product with ID "+ prodid+ " deleted",HttpStatus.OK);
//		}
//		catch(ProductNotFoundException ex1)
//		{
//			return new ResponseEntity<String>(ex1.getMessage(),HttpStatus.OK);
//		}
//	}
//	
//	@PutMapping("/update-product/{prodid}")
//	public ResponseEntity<?> updateProduct(@PathVariable int prodid,@RequestBody Product updatedProduct)
//	{
//		try
//		{
//		return new ResponseEntity<Product>(productService.updateProduct(prodid,updatedProduct),HttpStatus.OK);
//		}
//		catch(ProductNotFoundException ex1)
//		{
//			return new ResponseEntity<String>(ex1.getMessage(),HttpStatus.OK);
//		}
//	}
//}
