package com.quizpro.quizzpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<categorie> afficherCategories() {
        return categorieRepository.findAll();
    }
}