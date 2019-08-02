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
    public String greeting(Model model) {
        model.addAttribute("start", theatre.start());
        model.addAttribute("filter",theatre.filter());
        model.addAttribute("distinct", theatre.distinct());
        model.addAttribute("flatMap", theatre.flatMap());
        model.addAttribute("limit", theatre.limit());
        model.addAttribute("sorted", theatre.sorted());
        model.addAttribute("peek",theatre.peek());
        model.addAttribute("map", theatre.map());
        model.addAttribute("skip", theatre.skip());
        return "greeting";
    }
}
