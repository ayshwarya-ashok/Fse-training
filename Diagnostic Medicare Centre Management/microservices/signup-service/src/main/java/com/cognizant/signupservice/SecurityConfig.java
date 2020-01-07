package com.cognizant.signupservice;

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
					.antMatchers("/signup-service/users/admin-signup").anonymous()
					.antMatchers("/signup-service/users/doctor-signup").anonymous()
					.antMatchers("users/medicareServiceList").anonymous()
					.antMatchers("/signup-service/users/customer-signup").anonymous();
//					.antMatchers("/admin-sign-up").anonymous()
//					.antMatchers("/doctor-sign-up").anonymous()
//					.antMatchers("/medicare-services").permitAll()
//					.antMatchers("/customer-sign-up").anonymous();
		LOGGER.info("End");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
	}
}
