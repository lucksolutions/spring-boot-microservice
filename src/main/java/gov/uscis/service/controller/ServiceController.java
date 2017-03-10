package gov.uscis.service.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@RequestMapping(method=RequestMethod.GET, value="/")
    @ResponseBody
    String hello() {
        return "Hello World!";
    }
	
	@Secured("ROLE_USER")
	@RequestMapping(method=RequestMethod.GET, value="/secured")
    @ResponseBody
	String secured() {
		return "Access Granted";
	}

}
