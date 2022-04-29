package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class RedirectController {
    
    @GetMapping("/home")
    public RedirectView welcome(RedirectAttributes attributes) {
        //attributes.addFlashAttribute("flashAttribute", "redirectWithRedirectView");
        //attributes.addAttribute("pageToRequest", "paymentoverview");
        return new RedirectView("index.html");
    }
}
