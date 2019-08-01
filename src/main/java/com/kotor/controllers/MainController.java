package com.kotor.controllers;

import com.kotor.public_api.Theatre;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {
    @GetMapping("/greeting")
    public String greeting() throws IOException {
        Theatre theatre = new Theatre();
        theatre.parse();
        return "greeting";
    }
}
