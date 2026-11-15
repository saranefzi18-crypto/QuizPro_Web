package com.quizpro.quizzpro.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;
import com.quizpro.quizzpro.repositories.QuizRepository;


@Service
public class CategorieService {

    @Autowired
    private CategorieRepository catRepo;

<<<<<<< HEAD
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
=======
    @Autowired
    private QuizRepository quizRepo;

    public CategorieService(CategorieRepository catRepo, QuizRepository quizRepo){
        this.catRepo=catRepo;
        this.quizRepo=quizRepo;
    }

    public List<Categorie> getAll() {
        return catRepo.findAll();
    }

    @Transactional
    public void supprimer(Long id) {
        if (!catRepo.existsById(id)) {
            throw new RuntimeException("Catégorie introuvable");
        }

        if(quizRepo.existsByCategorieIdCat(id)){
            throw new RuntimeException("Impossible : ce thème contient encore des quiz");
        }

        catRepo.deleteById(id);
    }

    @Transactional 
    public Categorie getCat(Long id){
        if (!catRepo.existsById(id)) {
            throw new RuntimeException("Catégorie introuvable");
        }
        return catRepo.findByIdCat(id);
    }
}


>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9
