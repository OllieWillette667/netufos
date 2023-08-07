package com.vladceresna.netufos.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getMain(Model model){
        try {
            if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
                System.out.println("cabineto");
                return "redirect:cabineto";
            }else {
                System.out.println("about");
                return "redirect:about";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("about");
        return "redirect:about";
    }
    @GetMapping("/about")
    public String getAbout(Model model){
        return "about";
    }
}