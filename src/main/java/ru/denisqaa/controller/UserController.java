package ru.denisqaa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.denisqaa.dto.UserDTO;
import ru.denisqaa.mappers.UserMapper;
import ru.denisqaa.model.User;
import ru.denisqaa.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public String index(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", UserMapper.INSTANCE.toDTO(users));
        return "users/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        User user = userService.getById(id);
        UserDTO dto = UserMapper.INSTANCE.toDTO(user);
        model.addAttribute("user", dto);
        return "users/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") UserDTO userDTO) {
        return "users/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("user") UserDTO userDTO) {
        userService.saveUser(UserMapper.INSTANCE.toUser(userDTO));
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        User user = userService.getById(id);
        model.addAttribute("user", UserMapper.INSTANCE.toDTO(user));
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") UserDTO userDTO, @PathVariable("id") int id) {
        userService.updateUser(UserMapper.INSTANCE.toUser(userDTO), id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
