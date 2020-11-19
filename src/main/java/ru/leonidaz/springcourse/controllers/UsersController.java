package ru.leonidaz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leonidaz.springcourse.models.User;
import ru.leonidaz.springcourse.service.UserService;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showById(Model model, User user){
        model.addAttribute("user", user);
        return "users/showbyid";
    }
}
