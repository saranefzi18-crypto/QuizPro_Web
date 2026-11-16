package com.quizpro.quizzpro.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.quizpro.quizzpro.entities.Categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;
import com.quizpro.quizzpro.repositories.QuizRepository;


@Service
public class CategorieService {

    private CategorieRepository catRepo;

    private QuizRepository quizRepo;

    public CategorieService(CategorieRepository catRepo, QuizRepository quizRepo){
        this.catRepo=catRepo;
        this.quizRepo=quizRepo;
    }
    
    @Transactional
    public List<Categorie> afficherCategories() {
        return catRepo.findAll();
    }

    // Ajouter une catégorie (status bel defaut PENDING)
    @Transactional
    public Categorie ajouterCategorie(Categorie cat) {
        if (cat.getStatus() == null) {
            cat.setStatus("En Attent");
        }
        return catRepo.save(cat);
    }

    // Accepter une catégorie
    @Transactional
    public Categorie accepterCategorie(Long id) {
        Optional<Categorie> opt = catRepo.findById(id);
        if (opt.isPresent()) {
            Categorie cat = opt.get();
            cat.setStatus("Acceptee");
            return catRepo.save(cat);
        }
        throw new RuntimeException("Catégorie introuvable avec l'ID: " + id);
    }

    // Refuser une catégorie
    @Transactional
    public Categorie refuserCategorie(Long id) {
        Optional<Categorie> opt = catRepo.findById(id);
        if (opt.isPresent()) {
            Categorie cat = opt.get();
            cat.setStatus("Refusee");
            return catRepo.save(cat);
        }
        throw new RuntimeException("Catégorie introuvable avec l'ID: " + id);
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



