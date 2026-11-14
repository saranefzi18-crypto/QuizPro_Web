package com.quizpro.quizzpro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quizpro.quizzpro.entities.Utilisateur;
import com.quizpro.quizzpro.services.AdminService;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    public List<Utilisateur> getAllUtilisateurs() {
        return adminService.getAllUtilisateurs();
    }

    @DeleteMapping("/{id}")
    public void deleteUtilisateur(@PathVariable Long id) {
        adminService.deleteUtilisateur(id);
    }
}
