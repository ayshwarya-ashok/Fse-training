package com.cognizant.springWar.security;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.springWar.SpringWarApplication;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringWarApplication.class);
	
	 @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication()
	            .withUser("admin").password(passwordEncoder().encode("pwd")).roles("ADMIN")
	            .and()
	            .withUser("user").password(passwordEncoder().encode("pwd")).roles("USER");
	        	
	       
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        LOGGER.info("Start");
	        return new BCryptPasswordEncoder();
	    }
	    @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	    	httpSecurity.cors();
	        httpSecurity.csrf().disable().httpBasic().and()
	            .authorizeRequests().antMatchers("/countries").hasRole("USER")
            	.antMatchers("/authenticate").hasAnyRole("USER", "ADMIN")
            	.anyRequest().authenticated()
            	.and()
            	.addFilter(new JwtAuthorizationFilter(authenticationManager()));
	    }
	    
}

