package com.cognizant.DiagnosticMedicare.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.DiagnosticMedicare.exception.UserRegistrationException;
import com.cognizant.DiagnosticMedicare.model.Users;
import com.cognizant.DiagnosticMedicare.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("")

public class AuthenticationController {

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) throws UserRegistrationException {
		//LOGGER.info("START");
		Map<String, String> data = new HashMap<>();
	//	String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
	//	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	//	String user = authentication.getName();
		
		Users user = userRepository.findByUsername(getUser(authHeader));
		String userName = user.getUsername();
		String status = user.getApprove();
		
		if(userRepository.findByUsername(userName).getApprove().equalsIgnoreCase("PENDING")) {
			throw new UserRegistrationException("PENDING");
		} else if(userRepository.findByUsername(userName).getApprove().equalsIgnoreCase("REJECTED")) {
			throw new UserRegistrationException("REJECTED");
		}

		
		data.put("token", generateJwt(getUser(authHeader)));
		data.put("user", getUser(authHeader));
		data.put("role", user.getRole().getName());
		

		
		//LOGGER.info("END");
		return data;
	}

	private String getUser(String authHeader) {
		//LOGGER.info("START");
		String encodedCredentials = authHeader.split(" ")[1];
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		//LOGGER.info("END");
		System.out.println("hiii"+ decodedCredentials.split(":")[0]); 
		return decodedCredentials.split(":")[0];
	}

	private String generateJwt(String user) {
		//LOGGER.info("START");
		//LOGGER.debug("GENEARTE JWT");
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		//LOGGER.info("END");
		return token;
	}

}