package com.phase3.sportyshoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.entity.Products;
import com.phase3.sportyshoes.repository.ProductsRepository;

@Service
public class ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	
	public List<Products> findProductsByCategory(String Category){
		return productsRepository.findProductsByCategory(Category);
	}


}
