package com.lucksolutions.service.kafka;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void produceResponseMessage(String message) {
		log.info("Sending " + message);
		kafkaTemplate.send("testResponse", message);
	}
}
