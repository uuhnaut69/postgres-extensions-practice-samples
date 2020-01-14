package com.uuhnaut69.api.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uuhnaut69.api.model.Product;
import com.uuhnaut69.api.repository.ProductRepository;
import com.uuhnaut69.api.service.ProductService;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll(String text) {
		return productRepository.fullTextSearch(text);
	}

}
