package ru.leonidaz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leonidaz.springcourse.models.Role;
import ru.leonidaz.springcourse.models.User;
import ru.leonidaz.springcourse.service.UserService;
import ru.leonidaz.springcourse.userDAO.RoleDAO;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    private final RoleDAO roleDAO;

    @Autowired
    public AdminController(UserService userService, RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.allUsers());
        return "admin/all_users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showById(id));
        return "admin/show_by_id";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("ADMIN", true);
        model.addAttribute("USER",true);
        model.addAttribute("user", new User());
        return "admin/new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user,
                         @RequestParam(value = "ADMIN", required = false) boolean adminCheck,
                         @RequestParam(value = "USER", required = false) boolean userCheck) {
        Set<Role> roles = new HashSet<>();
        if (adminCheck)
            roles.add(roleDAO.findByID(2));
        if (userCheck)
            roles.add(roleDAO.findByID(1));
        user.setRoles(roles);
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model,
                       @PathVariable("id") int id,
                       @RequestParam(value = "ADMIN", required = false) boolean adminCheck,
                       @RequestParam(value = "USER", required = false) boolean userCheck) {
        model.addAttribute("ADMIN", adminCheck);
        model.addAttribute("USER", userCheck);
        model.addAttribute("user", userService.showById(id));
        return "admin/edit";
    }

    @PatchMapping("/{id}")
    public String editPerson(@ModelAttribute("user") User user,
                             @PathVariable("id") int id,
                             @RequestParam(value = "ADMIN", required = false) boolean adminCheck,
                             @RequestParam(value = "USER", required = false) boolean userCheck) {
        Set<Role> roles = new HashSet<>();
        if (adminCheck)
            roles.add(roleDAO.findByID(2));
        if (userCheck)
            roles.add(roleDAO.findByID(1));
        user.setRoles(roles);
        userService.edit(id, user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
