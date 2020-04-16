package com.elearningmate.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {
    @Autowired
    private KafkaTemplate<String, String> template;
    @PostMapping(path="/message/publish/{msg}")
    public String publish(@PathVariable String msg) {
        this.template.send("test", msg);
        return "Message published successfully";
    }
}
