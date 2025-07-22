package com.auth.service.security.service;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;


@Component
public class JWTServiceToken {

	
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject
	}
}
