package com.nsv.digital.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Sender.class);

    @Value("${kafka.topic.batchtopic}")
    String batchTopic;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String payload) {
        LOGGER.info("sending payload='{}' to topic='{}'", payload, batchTopic);
        kafkaTemplate.send(batchTopic, payload);
    }
}