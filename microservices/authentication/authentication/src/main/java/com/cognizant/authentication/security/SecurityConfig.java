package com.cognizant.authentication.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	AppUserDetailsService appUserDetailsService;
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		LOGGER.info("Start");
		// auth.inMemoryAuthentication()
		// .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
		// .and()
		// .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
		//auth.userDetailsService(inMemoryUserDetailsManager());
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
		LOGGER.info("End");
	}

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {

		List<UserDetails> userDetailsList = new ArrayList<>();
		LOGGER.info("Start");
//		userDetailsList.add(User.withUsername("user")
//								.password(passwordEncoder().encode("pwd"))
//								.roles("USER").
//								build());
//
//		userDetailsList.add(User.withUsername("admin")
//								.password(passwordEncoder().encode("pwd"))
//								.roles("ADMIN")
//								.build());

		LOGGER.info("End");
		return new InMemoryUserDetailsManager(userDetailsList);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		LOGGER.info("Start");
		httpSecurity.cors();
		httpSecurity.csrf()
				.disable().httpBasic()
				.and()
				//.sessionManagement()
				//.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				//.and()
				.authorizeRequests()
//				.antMatchers("/menu-items").anonymous()
//				.antMatchers("/menu-items")
//				.permitAll()
//				.antMatchers("/cart")
//				.permitAll()
//				.antMatchers("/users").anonymous()
				.anyRequest()
				.authenticated();
//				.and()
//				.addFilter(new JwtAuthorizationFilter(authenticationManager()));
		LOGGER.info("End");
	}
}

