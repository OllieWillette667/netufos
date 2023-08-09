package com.vladceresna.netufos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrimaryController {
    @GetMapping("/cabineto")
    public String getCabineto(Model model){
        return "cabineto";
    }

}
