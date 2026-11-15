package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.services.CategorieService;

@RestController
@RequestMapping("/api/categorie")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    // 1. Afficher toutes les catégories
    @GetMapping
    public List<categorie> afficherCategories() {
        return categorieService.afficherCategories();
    }

    // 2. Ajouter une catégorie
    @PostMapping("/add")
    public categorie ajouterCategorie(@RequestBody categorie cat) {
        return categorieService.ajouterCategorie(cat);
    }

    // 3. Accepter une catégorie
    @PutMapping("/accepter/{id}")
    public ResponseEntity<categorie> accepterCategorie(@PathVariable int id) {
        categorie updatedCat = categorieService.accepterCategorie(id);
        return ResponseEntity.ok(updatedCat);
    }

    // 4. Refuser une catégorie
    @PutMapping("/refuser/{id}")
    public ResponseEntity<categorie> refuserCategorie(@PathVariable int id) {
        categorie updatedCat = categorieService.refuserCategorie(id);
        return ResponseEntity.ok(updatedCat);
    }
}