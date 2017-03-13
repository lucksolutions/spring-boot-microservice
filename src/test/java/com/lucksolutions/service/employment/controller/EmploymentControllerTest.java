package com.lucksolutions.service.employment.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.lucksolutions.service.controller.AbstractControllerTest;

public class EmploymentControllerTest extends AbstractControllerTest {
	
	@Autowired
    private MockMvc mvc;

    @Test
    public void verify() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/employment/verify")
        		.content("{\"alienNumber\": 111111111}")
        		.contentType(MediaType.APPLICATION_JSON)
        		.secure(true)
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Alien Number 111111111 is: Employable")));
    }
    
    /**
     * When an invalid alien number is given, expect that the response code should be 400 Bad Request.
     * @throws Exception
     */
    @Test
    public void verify_ValidationFailure() throws Exception {
        mvc.perform(MockMvcRequestBuilders.post("/employment/verify")
        		.content("{\"alienNumber\": 0}")
        		.contentType(MediaType.APPLICATION_JSON)
        		.secure(true)
        		.accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
