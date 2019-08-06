package com.kotor.controllers;

import com.kotor.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.xml.bind.util.JAXBSource;
import java.io.IOException;


@Controller
public class MainController {
    private final UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/greeting")
    public String greeting(Model model) throws IOException {
        model.addAttribute("data",userService.all());
        return "greeting";
    }
}
