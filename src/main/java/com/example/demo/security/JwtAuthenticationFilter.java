package com.example.demo.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.util.StringUtils;

import com.example.demo.model.JwtAuthenticationToken;

public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

	

	public JwtAuthenticationFilter() {
		super("/rest/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		
		String headerToken = request.getHeader("auth");
		
		System.out.println("header values"+headerToken);
		
		if(headerToken==null || !headerToken.startsWith("token ")) {
			throw new RuntimeException("Jwt token missing");
		}
		
//		response.addHeader("Access-Control-Allow-Origin", headerToken);
//	    response.setHeader("Access-Control-Allow-Credentials", "true");
//	    response.addHeader("Access-Control-Max-Age", "10");
//	    response.addHeader("Access-Control-Expose-Headers", "X-CSRF-TOKEN");
//	    response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");

//	    String headers = request.getHeader("Access-Control-Request-Headers");
//
//	    if (!StringUtils.isEmpty(headers )) {
//	        response.addHeader("Access-Control-Allow-Headers", headers );
//	    }
//		
		String authenticationToken=headerToken.substring(6).trim();
		
		System.out.println("Auth values"+authenticationToken);
		
		JwtAuthenticationToken jwtAuthToken=new JwtAuthenticationToken(authenticationToken);
		return getAuthenticationManager().authenticate(jwtAuthToken);
				
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

	
	
	

}
