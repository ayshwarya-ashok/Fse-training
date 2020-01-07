package com.cogizant.country;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cogizant.country.controller.CountryController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc 
public class CountryApplicationTests {

	 @Autowired
	    private CountryController countryController;
	 @Autowired
	    private MockMvc mvc;
	@Test
	public void contextLoads() {
		assertNotNull(countryController);
	}
	 @Test
	    public void getCountry() throws Exception {
	        ResultActions actions = mvc.perform(get("/country"));
	        actions.andExpect(status().isOk());
	        actions.andExpect(jsonPath("$.code").exists());
	        actions.andExpect(jsonPath("$.code").value("In"));
	    }

}
