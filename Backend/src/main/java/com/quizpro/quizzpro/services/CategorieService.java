package com.quizpro.quizzpro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    // Afficher toutes les catégories
    public List<categorie> afficherCategories() {
        return categorieRepository.findAll();
    }

    // Ajouter une catégorie (status bel defaut PENDING)
    public categorie ajouterCategorie(categorie cat) {
        if (cat.getStatus() == null) {
            cat.setStatus("PENDING");
        }
        return categorieRepository.save(cat);
    }

    // Accepter une catégorie
    public categorie accepterCategorie(int id) {
        Optional<categorie> opt = categorieRepository.findById(id);
        if (opt.isPresent()) {
            categorie cat = opt.get();
            cat.setStatus("ACCEPTED");
            return categorieRepository.save(cat);
        }
        throw new RuntimeException("Catégorie introuvable avec l'ID: " + id);
    }

    // Refuser une catégorie
    public categorie refuserCategorie(int id) {
        Optional<categorie> opt = categorieRepository.findById(id);
        if (opt.isPresent()) {
            categorie cat = opt.get();
            cat.setStatus("REFUSED");
            return categorieRepository.save(cat);
        }
        throw new RuntimeException("Catégorie introuvable avec l'ID: " + id);
    }
}