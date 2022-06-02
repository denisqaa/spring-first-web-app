package ru.denisqaa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static java.time.LocalDate.now;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @GetMapping("/")
    public String printText(ModelMap model) {
        List<String> phrases = List.of("Hello.", "Welcome to first web app. ", String.format("It's %s", now()));
        model.addAttribute("messages", phrases);
        return "index";
    }
}
