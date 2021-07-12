package com.phase3.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.phase3.sportyshoes.entity.Users;
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT users FROM Users users LEFT  JOIN "
			+ "Products products ON products.users.id=users.id"
			+ " WHERE products.date=:date")
	public List<Users> findUsersByDate(@Param("date") String Date);
	
	@Query("SELECT products FROM Products products "
			+ "JOIN products.users users "
			+ "JOIN products.shoes shoes "
			+ "ON products.users.id=users.id "
			+ "WHERE products.date=:date")
	public List<Object> findUsersAndShoesByDate(@Param("date") String date);
	
	@Query("SELECT products FROM Products products "
			+ "JOIN products.users users "
			+ "JOIN products.shoes shoes "
			+ "ON products.users.id=users.id "
			+ "WHERE products.date=:date")
	public List<Object> searchByDate(@Param("date") String date);
	
	@Query("SELECT products FROM Products products "
			+ "JOIN products.users users "
			+ "JOIN products.shoes shoes "
			+ "ON products.users.id=users.id ")
	public List<Object> findAllObject();

	public List<Users>findByUsernameContainsAllIgnoreCase(String username);
	
	
	@Query("SELECT products FROM Products products "
			+ "JOIN products.users users "
			+ "JOIN products.shoes shoes "
			+ "ON  products.users.id=users.id "
			+ "WHERE shoes.category=:category")
	public List<Object> searchByCategory(@Param("category") String category);
	
}
