package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.quizpro.quizzpro.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    @Query("SELECT COUNT(q) FROM Quiz q WHERE q.categorie.idCat = :id")
    long nombreDeQuiz(@Param("id") int id);
}
