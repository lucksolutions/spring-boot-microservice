package gov.uscis.service.controller;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class ServiceControllerIT extends AbstractControllerIT {
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	@LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("https://localhost:" + port + "/");
    }

    @Test
    public void getHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("Hello World!"));
    }
}
