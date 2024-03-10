package org.example.service.consumer;

public interface KafkaConsumer {
    void listenBooksTopic(String message);
}
