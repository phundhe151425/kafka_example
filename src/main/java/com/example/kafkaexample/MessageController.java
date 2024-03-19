package com.example.kafkaexample;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/kafka/fhus")

public class MessageController {

    private final KafkaTemplate<String, Message> kafkaTemplate;

    public MessageController(KafkaTemplate<String, Message> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("message")
    public void test(@RequestBody MessageRecord messageRecord){
        Message message = new Message(messageRecord.message(), LocalDateTime.now());
        kafkaTemplate.send("fhus", "fhusKey", message);
    }
}
