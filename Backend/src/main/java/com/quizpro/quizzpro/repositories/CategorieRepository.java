package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.quizpro.quizzpro.entities.categorie;

@Repository
public interface CategorieRepository extends JpaRepository<categorie, Integer> {
}