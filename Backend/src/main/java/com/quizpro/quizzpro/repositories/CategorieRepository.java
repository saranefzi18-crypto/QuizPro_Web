package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quizpro.quizzpro.entities.categorie;

public interface CategorieRepository extends JpaRepository<categorie, Integer> {

    // Nombre de quiz qui utilisent ce thème
    @Query("SELECT COUNT(q) FROM Quiz q WHERE q.categorie.idCat = :id")
    long nombreDeQuiz(@Param("id") int id);
}
