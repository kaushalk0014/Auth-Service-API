package com.auth.service.security.service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;


@Component
public class JWTServiceToken {

	private static final String SECRET = "eqvwj2Gvf/6iWs9DKZHgOtGp/+i0avFck1kF1rU7Eb8=";
	
	public String generateToken(String username) {
		
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
	}

	private Key getSignKey() {
	    return Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
	}
}
