package com.lucksolutions.service.kafka;

import lombok.extern.apachecommons.CommonsLog;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@CommonsLog
public class KafkaConsumer {

	@KafkaListener(topics="test")
	public void processMessage(String messageContent) {
		log.info("Received message from Kafka: " + messageContent);
	}
}
