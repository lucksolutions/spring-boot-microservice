package com.lucksolutions.service.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucksolutions.service.api.Version;

@RestController
@RequestMapping(produces=Version.V1, consumes=Version.V1)
public class ServiceController {

	@RequestMapping(method=RequestMethod.GET, value="/")
    String hello() {
        return "Hello World!";
    }
	
	@Secured("ROLE_USER")
	@RequestMapping(method=RequestMethod.GET, value="/secured")
	String secured() {
		return "Access Granted";
	}

}
