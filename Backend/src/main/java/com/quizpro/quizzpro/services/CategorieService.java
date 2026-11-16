package com.quizpro.quizzpro.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;

@Service
public class CategorieService {

    private CategorieRepository catRepo;

    public CategorieService(CategorieRepository catRepo) {
        this.catRepo = catRepo;
    }

    public List<categorie> afficherCategories() {
        return catRepo.findAll();
    }
}