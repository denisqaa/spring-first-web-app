package ru.denisqaa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.denisqaa.dto.UserDTO;
import ru.denisqaa.service.UserService;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") UserDTO userDTO) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") UserDTO userDTO) {
        userService.saveUser(userDTO);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "users/edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("user") UserDTO userDTO, @PathVariable("id") int id) {
        userService.updateUser(userDTO, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
