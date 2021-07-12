package com.phase3.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phase3.sportyshoes.entity.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
	
	@Query("SELECT products FROM Products products LEFT JOIN Shoes shoes on products.shoes.pid=shoes.pid WHERE shoes.category=:category")
	public List<Products> findProductsByCategory(@Param("category") String category);
	
	

	
	
	
}
