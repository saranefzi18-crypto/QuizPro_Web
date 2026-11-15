package com.quizpro.quizzpro.services;

import java.util.List;

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


