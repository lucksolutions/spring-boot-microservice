package com.lucksolutions.service.audit;

import java.util.HashMap;
import java.util.Map;

import lombok.extern.apachecommons.CommonsLog;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.stereotype.Component;

@Component
@Aspect
@CommonsLog
public class AuditAdvice {
	
	@Autowired
	private AuditEventRepository auditRepository;

	@Before("@annotation(auditable)")
	public void fireAuditEvent(Auditable auditable) {
		final String principal = "user";
		final Map<String, Object> eventData = new HashMap<>();
		
		final AuditEvent event = new AuditEvent(principal, auditable.eventType(), eventData);
		
		log.debug("Firing Audit Event: " + event);
		auditRepository.add(event);
	}
}
