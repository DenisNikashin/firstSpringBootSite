package com.examle.messageManager;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessagesController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name",
                                         required=false,
                                         defaultValue="World") String name,
                                                                Map <String, Object> model) {
        model.put("name", name);
        return "greeting"; // <-- данная строка возвращает VIEW в виде файла greeting.mustache
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("outputSomeInfo", "Hello everybody");
        return "main";
    }

}
