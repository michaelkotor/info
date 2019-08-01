package com.kotor.controllers;

import com.kotor.public_api.Theatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {
    @Autowired
    private Theatre theatre;

    @GetMapping("/greeting")
    public String greeting() throws IOException {
        theatre.parse();
        return "greeting";
    }
}
