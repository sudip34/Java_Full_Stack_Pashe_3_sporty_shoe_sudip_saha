package com.phase3.sportyshoes.repository;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.phase3.sportyshoes.entity.Security;


public class CustomUserDetails implements UserDetails {
	
	private Security security;
	
	public CustomUserDetails(Security security) {
		super();
		this.security = security;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(
				new SimpleGrantedAuthority(security.getRole()));
	}

	@Override
	public String getPassword() {
		return security.getPassword();
	}

	@Override
	public String getUsername() {
		
		return security.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
