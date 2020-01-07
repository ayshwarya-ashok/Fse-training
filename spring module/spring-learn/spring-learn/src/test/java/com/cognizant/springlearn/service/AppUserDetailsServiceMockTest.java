package com.cognizant.springlearn.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import com.cognizant.springlearn.Role;
import com.cognizant.springlearn.User;
import com.cognizant.springlearn.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AppUserDetailsServiceMockTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppUserDetailsServiceMockTest.class);
	
	@Test
    public void mockTestLoadUserByUsername() {
        LOGGER.info("Start");
        UserRepository repository = Mockito.mock(UserRepository.class);
        when(repository.findByUserName("user")).thenReturn(createUser());
        AppUserDetailsService service = new AppUserDetailsService(repository);
        UserDetails user = service.loadUserByUsername("user");
        String expected = "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK";
        assertEquals(expected, user.getPassword());
        LOGGER.info("End");
    }
	public User createUser() {
		Set<Role> roleList = new HashSet<Role>();
		roleList.add(new Role(2, "USER"));
		User user = new User(3, "Smith", "$2a$10$R/lZJuT9skteNmAku9Y7aeutxbOKstD5xE5bHOf74M2PHZipyt3yK", roleList);
		return user;
	}
}
