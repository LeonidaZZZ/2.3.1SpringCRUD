package ru.leonidaz.springcourse.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leonidaz.springcourse.models.Role;
import ru.leonidaz.springcourse.models.User;
import ru.leonidaz.springcourse.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users", userService.allUsers());
        return "admin/allusers";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model){
        model.addAttribute("user", userService.showById(id));
        return "admin/showbyid";
    }

    @GetMapping("/new")
    public String newPerson(Model model){
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("user", userService.showById(id));
        return "admin/edit";
    }
    @PatchMapping("/{id}")
    public String editPerson(@ModelAttribute("user") User user, @PathVariable("id") int id){
        userService.edit(id,user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id){
        userService.delete(id);
        return "redirect:/admin";
    }
}
