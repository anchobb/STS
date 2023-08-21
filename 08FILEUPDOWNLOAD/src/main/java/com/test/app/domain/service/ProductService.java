package com.test.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.app.domain.dto.ProductDto;
import com.test.app.domain.mapper.ProductMapper;


@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	public void addProduct(ProductDto dto, String path) {
		System.out.println("ProductService's addProduct...");
		productMapper.addProduct(dto.getProductCode(), path, dto.getProductName(), dto.getProductType());
		
	}
}
