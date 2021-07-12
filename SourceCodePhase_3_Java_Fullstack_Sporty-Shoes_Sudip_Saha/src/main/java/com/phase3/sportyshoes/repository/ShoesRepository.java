package com.phase3.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.phase3.sportyshoes.entity.Shoes;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Integer> {

	
	@Query("SELECT shoes FROM Shoes shoes LEFT  JOIN "
			+ "Products products on products.shoes.pid=shoes.pid"
			+ " WHERE products.date=:date")
	public List<Shoes> findShoesByDate(@Param("date") String Date);
	

	
	
	
	
	
	
}
