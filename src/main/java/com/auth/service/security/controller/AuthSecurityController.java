package com.auth.service.security.controller;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.security.dto.AuthRequestDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthSecurityController {
 
	private static final Logger logger = LoggerFactory.getLogger(AuthSecurityController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody AuthRequestDTO authRequestDTO) {
	 
		logger.info("---------info------: "+ authRequestDTO.getUsername());
		
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(),
				authRequestDTO.getPassword()));
		
		
		
		return ResponseEntity.ok("");
	}
}
