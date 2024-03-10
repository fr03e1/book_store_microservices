package org.example.service.producer;

import lombok.RequiredArgsConstructor;
import org.example.constant.KafkaConstant;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducerImpl implements KafkaProducer{
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        kafkaTemplate.send(KafkaConstant.BOOKS_TOPIC, message);
    }
}
