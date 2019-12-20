package com.example.demo.security;

import org.springframework.stereotype.Component;

import com.example.demo.model.JWTUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JWTValidator {

	private String key="youtube";

	public Object validate(String token) {
		JWTUser jwtUser=null;
		try {
			Claims claims=Jwts.parser()
					.setSigningKey(key).parseClaimsJws(token).getBody();
			jwtUser =new JWTUser();
					
			jwtUser.setUserName(claims.getSubject());	
			
			jwtUser.setID(Long.parseLong((String)claims.get("userID")));
			
			jwtUser.setRole((String)claims.get("role"));
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
				
		return jwtUser;
	}
	
}
