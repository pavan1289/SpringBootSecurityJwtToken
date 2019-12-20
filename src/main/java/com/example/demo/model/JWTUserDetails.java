package com.example.demo.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JWTUserDetails implements UserDetails {
	
	String userName;
	Long id;
	String role;
	String token;
	Collection<? extends GrantedAuthority> grantedAuth;
	
	public JWTUserDetails(String userName,long id,String role,String token,List<GrantedAuthority> grantedAuth){
		
		this.userName=userName;
		this.id=id;
		this.role=role;
		this.token=token;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return userName;
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
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getUserName() {
		return userName;
	}

	

	public Long getId() {
		return id;
	}

	

	public String getRole() {
		return role;
	}


	public String getToken() {
		return token;
	}

	

	public Collection<? extends GrantedAuthority> getGrantedAuth() {
		return grantedAuth;
	}

	
	

}
