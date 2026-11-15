package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizpro.quizzpro.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}