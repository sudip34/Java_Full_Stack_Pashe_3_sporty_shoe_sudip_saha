package com.phase3.sportyshoes.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.entity.Users;
import com.phase3.sportyshoes.repository.UsersRepository;

@Service
public class UsersService {
	@Autowired
	private UsersRepository usersRepository;
	
	public List<Users> findUsersByDate(String date){
		return usersRepository.findUsersByDate(date);
	}
	
	public List<Object> findUsersAndShoesByDate(String date){
		return usersRepository.findUsersAndShoesByDate(date);
	}
	
	
	
	
	public List<Users> findAll() {
		return usersRepository.findAll();
	}
	public List<Object> findAllObject() {
		return usersRepository.findAllObject();
	}
	



	public List<Object> searchByDate(String date) {
		List<Object> results = null;
		if (date != null && (date.trim().length() > 0)) {
			results = usersRepository.searchByDate(date);
		}
		else {
			results = findAllObject();
		}
		
		return results;
	}

	
	public List<Object> searchByCategory(String category) {
		List<Object> results = null;
		if (category != null && (category.trim().length() > 0)) {
			results = usersRepository.searchByCategory(category);
		}
		else {
			results = findAllObject();
		}
		
		return results;
	}

	
	
	public List<Users> sreachByUsername(String username) {
		// add a new List of  Users
		List<Users> users= new ArrayList<>();
		if(username!=null && (username.trim().length()>0)) {
			users=usersRepository.findByUsernameContainsAllIgnoreCase(username);
		}
		return users;
	}

	




}
