package com.mrzmorgan;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(
        topics = "mrzmorgan",
        groupId = "groupId"
    )
    void listener(Message data) {
        System.out.println("Listener received: " + data + " !!!");
    }
}
