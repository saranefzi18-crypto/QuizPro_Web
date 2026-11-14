package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.services.CategorieService;

@RestController
@RequestMapping("/api/categorie")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    @GetMapping
    public List<categorie> afficherCategories() {
        return categorieService.afficherCategories();
    }
}