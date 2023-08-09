package com.vladceresna.netufos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SocialController {

    @GetMapping("/social/chats")
    public String getChats(Model model){
        return "chat";
    }
    @GetMapping("/social/postboard")
    public String getPostBoard(Model model){
        return "chat";
    }
}
