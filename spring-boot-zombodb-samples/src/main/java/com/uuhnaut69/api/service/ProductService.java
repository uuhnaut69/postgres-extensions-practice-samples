package com.uuhnaut69.api.service;

import java.util.List;

import com.uuhnaut69.api.model.Product;

public interface ProductService {
	List<Product> findAll(String text);

	void insert(Product product);
}
