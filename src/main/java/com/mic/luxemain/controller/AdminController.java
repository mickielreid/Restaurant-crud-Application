package com.mic.luxemain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/login")
    public String toLogin(Model model) {
        model.addAttribute("errMsg", "Sorry User NAme not found");
        return "security/login.html";
    }

    @GetMapping("/admin")
    public String redirecttoLogin() {
        return "redirect:/item/read";
    }


}
