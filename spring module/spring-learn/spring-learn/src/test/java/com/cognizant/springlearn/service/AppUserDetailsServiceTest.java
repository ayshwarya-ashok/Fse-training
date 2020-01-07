package com.cognizant.springlearn.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppUserDetailsServiceTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsServiceTest.class);
	
	@Autowired
	AppUserDetailsService appUserDetailsService;
	
	 @Test
	    public void testLoadByUserName() {
	        LOGGER.info("Start");
	        UserDetails user = appUserDetailsService.loadUserByUsername("user");
	        String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
	        assertEquals(expected, user.getPassword());
	        LOGGER.info("End");
	    }
}
