package com.excelr.ExcelRMay2026BatchSpringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.ExcelRMay2026BatchSpringboot.controller.ProductController;
import com.excelr.ExcelRMay2026BatchSpringboot.entity.Product;
import com.excelr.ExcelRMay2026BatchSpringboot.exception.ProductNotFoundException;
import com.excelr.ExcelRMay2026BatchSpringboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product getSingleProduct(int prodid) throws ProductNotFoundException
	{
		if(productRepository.existsById(prodid))
		{
			return productRepository.findById(prodid).get();
		}
		
		throw new ProductNotFoundException("Product with ID " +prodid + " does not exist");
	}

}
