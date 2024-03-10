package org.example.service.producer;

public interface KafkaProducer {
    void sendMessage(String message);
}
