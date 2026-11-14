package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizpro.quizzpro.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}
