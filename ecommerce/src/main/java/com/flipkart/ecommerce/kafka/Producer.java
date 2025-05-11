package com.flipkart.ecommerce.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
private static final String TOPIC = "notification";
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;
public String sendMessage(String message) {

    String str = String.valueOf(kafkaTemplate.send(TOPIC,message));
    return str;
}
}
