package com.auth.service.security.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.service.security.dto.AuthRequestDTO;
import com.auth.service.security.dto.AuthResponse;
import com.auth.service.security.service.JWTServiceToken;

@RestController
@RequestMapping("/api/auth")
public class AuthSecurityController {

	private static final Logger logger = LoggerFactory.getLogger(AuthSecurityController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JWTServiceToken jwtServiceToken;

	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequestDTO authRequestDTO) {

		try {
			logger.info("---------info------: " + authRequestDTO.getUsername());

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequestDTO.getUsername(),
					authRequestDTO.getPassword()));

			String jwtToken = jwtServiceToken.generateToken(authRequestDTO.getUsername());

			AuthResponse authResponse = new AuthResponse(jwtToken);
			return ResponseEntity.ok(authResponse);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(new AuthResponse("Invalid username and password"));
		}
	}
}
