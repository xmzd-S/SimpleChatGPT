package com.example.simplechat.controller;


import com.example.simplechat.domain.ChatCompletion;
import com.example.simplechat.domain.Message;
import com.example.simplechat.util.ChatGptClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1")
public class ApiController {
    @Autowired
    private ChatGptClient chatGptClient;
    @GetMapping("models")
    public Object models()  {
        return chatGptClient.models().blockingGet();
    }
    @GetMapping("subscription")
    public Object subscription()  {
        return chatGptClient.subscription().blockingGet();
    }

    @GetMapping("chat")
    public Object chat(){
        Message message = Message.builder().role(Message.Role.USER).content("你好啊我的伙伴！").build();
        ChatCompletion chatCompletion = ChatCompletion
                .builder()
                .messages(Arrays.asList(message))
                .model(ChatCompletion.Model.GPT_3_5_TURBO.getName())
                .build();
        return chatGptClient.chatCompletion(chatCompletion).blockingGet();
    }
}
