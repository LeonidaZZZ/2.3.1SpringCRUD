package ru.leonidaz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leonidaz.springcourse.models.User;
import ru.leonidaz.springcourse.service.ServiceImpl;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final ServiceImpl service;
    @Autowired
    public UsersController(ServiceImpl service) {
        this.service = service;
    }

    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users", service.allUsers());
        return "users/allusers";
    }
    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", service.showById(id));
        return "users/showbyid";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", service.showById(id));
        return "users/edit";
    }
    @PatchMapping("/{id}")
    public String editPerson(@ModelAttribute("user") User user, @PathVariable("id") int id){
        service.edit(id,user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        service.delete(id);
        return "redirect:/users";
    }
}
