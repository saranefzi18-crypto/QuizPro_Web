package com.quizpro.quizzpro.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.services.CategorieService;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

    private CategorieService catServ;

    public CategorieController(CategorieService catServ) {
        this.catServ = catServ;
    }

    @GetMapping
    public List<categorie> getAll() {
        return catServ.afficherCategories();
    }
}