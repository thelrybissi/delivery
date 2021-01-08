package com.horse.delivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.horse.delivery.dto.ProductDto;
import com.horse.delivery.entities.Product;
import com.horse.delivery.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<ProductDto> findAll() {
		List<Product> listProduct = productRepository.findAllByOrderByNameAsc();
		return listProduct.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
		
	}
}
