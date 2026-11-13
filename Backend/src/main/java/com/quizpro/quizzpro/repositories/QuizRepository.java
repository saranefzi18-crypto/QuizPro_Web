package com.quizpro.quizzpro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.entities.Utilisateur;

public interface QuizRepository extends JpaRepository<Quiz, Long>{
    
    public List<Quiz> findByStatut(String statut);
}
