package com.example.demo.model;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@SuppressWarnings("serial")
public class JwtAuthenticationToken extends UsernamePasswordAuthenticationToken {

	
	private String token;
	public JwtAuthenticationToken(String token){
		super(null,null);
		System.out.println("Setter Token Befor Constructor :" +token);
		this.token=token;
		System.out.println("Setter Token After Constructor :" +token);
	}
	@Override
	public Object getCredentials() {
		return  null;
	}
	@Override
	public Object getPrincipal() {
		return null;
	}
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		System.out.println("Setter Token Values :" +token);
		this.token = token;
	}
	
	

}
