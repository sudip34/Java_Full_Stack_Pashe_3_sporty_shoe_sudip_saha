package com.phase3.sportyshoes.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.phase3.sportyshoes.entity.Security;
import com.phase3.sportyshoes.repository.CustomUserDetails;
import com.phase3.sportyshoes.repository.SecurityRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private SecurityRepository securityRepository;
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Security sc=securityRepository.findByUsername(username);
		
		if(sc==null) {
			throw new UsernameNotFoundException("user not found");
		}
		
		return new CustomUserDetails(sc);
	}

}
