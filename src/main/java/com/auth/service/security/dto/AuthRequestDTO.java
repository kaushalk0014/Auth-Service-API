package com.auth.service.security.dto;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@SuppressWarnings("serial")
public class AuthRequestDTO implements Serializable{

 
	@Size(message = "Username required")
	@NotNull
	private String username;
	
	@Size(min = 8, max=40, message = "Password must be between 8 and 40 characters long")
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
