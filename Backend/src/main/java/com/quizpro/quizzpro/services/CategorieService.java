package com.quizpro.quizzpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository catRepo;

    public List<categorie> getAll() {
        return catRepo.findAll();
    }

    @Transactional
    public void supprimer(int id) {
        if (!catRepo.existsById(id)) {
            throw new RuntimeException("Catégorie introuvable");
        }

        // On refuse de supprimer un thème qui contient encore des quiz
        if (catRepo.nombreDeQuiz(id) > 0) {
            throw new RuntimeException("Impossible : ce thème contient encore des quiz");
        }

        catRepo.deleteById(id);
    }
}
