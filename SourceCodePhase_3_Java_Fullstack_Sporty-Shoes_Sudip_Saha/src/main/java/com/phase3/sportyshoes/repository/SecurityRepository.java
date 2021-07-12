package com.phase3.sportyshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phase3.sportyshoes.entity.Security;

@Repository
public interface SecurityRepository extends JpaRepository<Security, Integer> {
	Security findByUsername(String username);
}
