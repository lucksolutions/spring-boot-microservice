package com.lucksolutions.service.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.x509;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.lucksolutions.service.api.Version;

public class ServiceControllerTest extends AbstractControllerTest {
	@Autowired
    private MockMvc mvc;
	
	@Value("${client.ssl.cert}")
	String clientCert;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/")
        		.secure(true)
        		.accept(Version.V1)
        		.contentType(Version.V1))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello World!")));
    }
    
    @Test
    @WithMockUser(roles="USER")
    public void getSecured() throws Exception {
    	
        mvc.perform(MockMvcRequestBuilders.get("/secured")
        			.secure(true)
        			.with(x509(clientCert))
        			.accept(Version.V1)
        			.contentType(Version.V1))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Access Granted")));
    }
}
