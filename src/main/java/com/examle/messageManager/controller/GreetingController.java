package com.examle.messageManager.controller;

import com.examle.messageManager.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",
            required=false,
            defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting"; // <-- данная строка возвращает VIEW в виде файла greeting.mustache
    }
}
