package edu.wgu.d387_sample_code.translation;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ArrayNode;

@CrossOrigin
@RestController
@RequestMapping("/messages")
public class WelcomeMessageController {

    @GetMapping
    public ArrayNode getWelcomeMessages() {
        return TranslateMessage.getWelcomeMessage();
    }


}
