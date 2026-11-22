package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.quizpro.quizzpro.entities.Utilisateur;
import com.quizpro.quizzpro.services.UtilisateurService;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utlServ;

    // GET http://localhost:8081/api/utilisateurs
    @GetMapping
    public List<Utilisateur> getAll() {
        return utlServ.getAll();
    }

    // PUT http://localhost:8081/api/utilisateurs/5/desactiver
    @PutMapping("/{id}/desactiver")
    public ResponseEntity<?> desactiver(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(utlServ.changerEtat(id, false));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // PUT http://localhost:8081/api/utilisateurs/5/activer
    @PutMapping("/{id}/activer")
    public ResponseEntity<?> activer(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(utlServ.changerEtat(id, true));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
