package ru.denisqaa.controller;

import static java.time.LocalDate.now;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String printText(ModelMap model) {
    List<String> phrases = List.of("Hello.", "Welcome to first web app.", String.format("It's %s", now()));
    model.addAttribute("messages", phrases);
    return "index";
  }
}
