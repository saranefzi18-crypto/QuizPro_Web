package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.services.CategorieService;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

    @Autowired
    private CategorieService catServ;

    // GET http://localhost:8081/api/categories
    @GetMapping
    public List<categorie> getAll() {
        return catServ.getAll();
    }

    // DELETE http://localhost:8081/api/categories/5
    @DeleteMapping("/{id}")
    public ResponseEntity<String> supprimer(@PathVariable int id) {
        try {
            catServ.supprimer(id);
            return ResponseEntity.ok("Catégorie supprimée");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
