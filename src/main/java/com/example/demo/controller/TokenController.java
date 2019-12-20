package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.JWTUser;
import com.example.demo.security.JwtGenerator;

@RestController
@RequestMapping("/token")
public class TokenController {
	
	
	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtgenerator) {
		this.jwtGenerator=jwtgenerator;
	}

	@PostMapping
	public String generateToken(@RequestBody JWTUser jwtUser) {
	return 	jwtGenerator.generate(jwtUser);
	}

	
}
