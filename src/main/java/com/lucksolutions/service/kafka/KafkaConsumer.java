package com.lucksolutions.service.kafka;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class KafkaConsumer {
	
	@Autowired
	private KafkaProducer producer;

	@KafkaListener(topics="test")
	public void processMessage(String messageContent) {
		log.info("Received message from Kafka: " + messageContent);
		producer.produceResponseMessage("Response to: " + messageContent);
	}
}
