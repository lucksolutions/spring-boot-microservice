package com.lucksolutions.service.employment.service;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucksolutions.service.audit.Auditable;
import com.lucksolutions.service.employment.model.VerificationRequest;

@RestController
@RequestMapping("/employment")
public class EmploymentController {

	@Auditable(eventType="/employment/verify request")
	@PostMapping(value="/verify", consumes = "application/json")
	String verifyEmployability(@RequestBody @Valid VerificationRequest request) {
		return String.format("Alien Number %s is: Employable", request.getAlienNumber());
	}
}
