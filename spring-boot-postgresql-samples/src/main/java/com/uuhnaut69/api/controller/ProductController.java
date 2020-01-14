package com.uuhnaut69.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uuhnaut69.api.model.Product;
import com.uuhnaut69.api.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<Product> fullTextQuery(@RequestParam(value = "text", defaultValue = "") String text) {
		return productService.findAll(text);
	}
	
	@PostMapping
	public void insert(@RequestBody Product product) {
		productService.insert(product);
	}
}
