package com.examle.messageManager.controller;

import com.examle.messageManager.domaine.Message;
import com.examle.messageManager.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private MessageRepo messageRepo;

    private void workingWithMessages(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        workingWithMessages(model);
        return "main";
    }

    @PostMapping
    public String add(@RequestParam String text, Map<String, Object> model) {
        Message message = new Message(text);
        messageRepo.save(message);
        workingWithMessages(model);
        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByText(filter);
        } else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);
        return "main";
    }
}
