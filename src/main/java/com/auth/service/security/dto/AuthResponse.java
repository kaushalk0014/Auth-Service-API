package com.auth.service.security.dto;

public class AuthResponse {

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public AuthResponse() {
	}

	public AuthResponse(String token) {
		this.token = token;
	}
	
	
}
