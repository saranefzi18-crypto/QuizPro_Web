package com.quizpro.quizzpro.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.quizpro.quizzpro.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {


    List<Quiz> findByFormateurId(Long formateurId);

}