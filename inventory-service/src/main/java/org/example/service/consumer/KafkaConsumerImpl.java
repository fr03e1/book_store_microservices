package org.example.service.consumer;

import org.example.constant.KafkaConstant;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerImpl implements KafkaConsumer {

    @Override
    @KafkaListener(topics = KafkaConstant.BOOKS_TOPIC)
    public void listenBooksTopic(String message) {
        System.out.println(message);
    }
}
