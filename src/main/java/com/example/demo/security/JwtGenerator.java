package com.example.demo.security;

import org.springframework.stereotype.Component;

import com.example.demo.model.JWTUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JWTUser jwtUser) {
		
		Claims claims=Jwts.claims()
				.setSubject(jwtUser.getUserName());
		
		claims.put("id", String.valueOf(jwtUser.getSetID()));
		claims.put("role",jwtUser.getRole());
		
		
		
		return Jwts.builder().setClaims(claims)
		.signWith(SignatureAlgorithm.HS512,"youtube").compact();
	}

}
