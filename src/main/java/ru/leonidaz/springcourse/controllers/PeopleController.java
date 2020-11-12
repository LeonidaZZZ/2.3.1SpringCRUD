package ru.leonidaz.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.leonidaz.springcourse.PersonDAO.PersonDAO;
import ru.leonidaz.springcourse.models.Person;

@Controller
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PersonDAO personDAO;

    @GetMapping
    public String index(Model model){
        System.out.println("----index----");
        model.addAttribute("people",personDAO.index());
        return "people/index";
    }
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        System.out.println("----show-----");
        model.addAttribute("person",personDAO.show(id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person){
        System.out.println("----newPerson-----");
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") Person person){
        System.out.println("-----create----");
        personDAO.save(person);
        return "redirect:/people";
    }
}
