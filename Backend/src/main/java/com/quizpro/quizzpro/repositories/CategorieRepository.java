package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import org.springframework.stereotype.Repository;
import com.quizpro.quizzpro.entities.categorie;

@Repository
public interface CategorieRepository extends JpaRepository<categorie, Integer> {
}
=======

import com.quizpro.quizzpro.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    public Categorie findByIdCat(Long id);
}

>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9
