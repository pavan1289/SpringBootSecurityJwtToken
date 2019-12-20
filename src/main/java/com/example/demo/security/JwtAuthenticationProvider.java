package com.example.demo.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.model.JWTUser;
import com.example.demo.model.JWTUserDetails;
import com.example.demo.model.JwtAuthenticationToken;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	
	@Autowired
	JWTValidator jwtValdator;
	
	@Override
	public boolean supports(Class<?> authentication) {
		return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	}

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken tokenAuthenticationToken)
			throws AuthenticationException {
		
		JwtAuthenticationToken jwtToken=(JwtAuthenticationToken)tokenAuthenticationToken;
		
		String token=jwtToken.getToken();
		
		JWTUser jwtuser=(JWTUser)jwtValdator.validate(token);
		
		if(jwtuser==null) {
			
			throw new RuntimeException("Jwt token is not correct");
		}
		List<GrantedAuthority> grantedAuthList = AuthorityUtils.commaSeparatedStringToAuthorityList(jwtuser.getRole());
		
		return new JWTUserDetails(jwtuser.getUserName(),jwtuser.getSetID(),jwtuser.getRole(),token,grantedAuthList);
		
	}

}
