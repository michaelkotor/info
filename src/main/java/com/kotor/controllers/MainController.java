package com.kotor.controllers;

import com.kotor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;


@Controller
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/greeting")
    public String greeting(Model model) throws IOException {
        model.addAttribute("data",userService._());
        return "greeting";
    }
}
