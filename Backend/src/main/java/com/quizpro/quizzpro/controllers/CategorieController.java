package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.quizpro.quizzpro.entities.Categorie;
import com.quizpro.quizzpro.services.CategorieService;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

    @Autowired
    private CategorieService catServ;

    public CategorieController(CategorieService catServ){
        this.catServ=catServ;
    }

    @GetMapping
    public List<Categorie> getAll() {
        return catServ.getAll();
    }

    @DeleteMapping("/{id}")
    public void supprimerCat(@PathVariable Long id){
        catServ.supprimer(id);
    }
}
