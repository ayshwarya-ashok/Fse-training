package com.cognizant.medicaremanagement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("Start");
		httpSecurity.cors();
		httpSecurity.csrf()
					.disable()
					.httpBasic()
					.and()
					.authorizeRequests()
//					.antMatchers("/customer").anonymous()
//					.antMatchers("/admin").anonymous();
//					.antMatchers("/admin-sign-up").anonymous()
//					.antMatchers("/doctor-sign-up").anonymous()
//					.antMatchers("/medicare-services").permitAll()
//					.antMatchers("/customer-sign-up").anonymous()
					.antMatchers("/medicare-services").permitAll()
					.antMatchers("/removeDoctor-signup").permitAll()
	         		.antMatchers("/removeCustomer-signup").permitAll();
		LOGGER.info("End");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
	}
}
