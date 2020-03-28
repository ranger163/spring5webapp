package me.inassar.spring5webapp.controllers;

import me.inassar.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute(repository.findAll());
        return "authors";
    }
}
