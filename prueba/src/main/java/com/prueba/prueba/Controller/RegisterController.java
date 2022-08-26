package com.prueba.prueba.Controller;

import com.prueba.prueba.Sevices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
    @Autowired
    private UserService service;
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/")
    public String seeIndex(Model modelo) {
        modelo.addAttribute("usuarios", service.listUsers());
        return "index";
    }
}
