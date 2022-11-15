package com.mrzmorgan;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping("api/v1/messages")
@RestController
public class MessageController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

//    @PostMapping
//    public void publish(@RequestBody MessageRequest request) {
//        kafkaTemplate.send("mrzmorgan", request.message());
//    }

    @PostMapping
    public void publish(@RequestBody MessageRequest request) {
        var message = new Message(request.message(), LocalDateTime.now());
        kafkaTemplate.send("mrzmorgan", message);
    }
}
