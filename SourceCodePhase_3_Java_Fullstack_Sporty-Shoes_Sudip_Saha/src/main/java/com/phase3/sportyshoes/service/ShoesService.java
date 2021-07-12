package com.phase3.sportyshoes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.entity.Shoes;
import com.phase3.sportyshoes.repository.ShoesRepository;

@Service
public class ShoesService {
	@Autowired
	private ShoesRepository shoesRepository;
	
	public List<Shoes> findShoesByDate( String date){
		return shoesRepository.findShoesByDate(date);
	}


	public List<Shoes> findAll() {
		
		return shoesRepository.findAll();
	}


	


	public void deleteById(int theId) {
		shoesRepository.deleteById(theId);
		
	}
	public Shoes findById(int theId) {
		
		Optional<Shoes> result= shoesRepository.findById(theId);
		
		Shoes theShoe=null;
		if (result.isPresent()) {
			theShoe = result.get();
		}
		else {
			// we didn't find the shoe
			throw new RuntimeException("Did not find shoe id - " + theId);
		}
		
		return theShoe;
	}

	public void save(Shoes theShoe) {
		shoesRepository.save(theShoe);
		
	}
	


	
}
