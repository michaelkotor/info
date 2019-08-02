package com.kotor.controllers;

import com.kotor.public_api.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.io.IOException;

@Controller
public class MainController {
    private final Theatre theatre;

    @Autowired
    public MainController(Theatre theatre) {
        this.theatre = theatre;
    }

    @GetMapping("/greeting")
    public String greeting(Model model) throws IOException {
        model.addAttribute("data", theatre.parse());
        return "greeting";
    }
}
