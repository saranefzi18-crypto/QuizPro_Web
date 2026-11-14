package com.quizpro.quizzpro.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizpro.quizzpro.entities.Question;

public interface QuestionRepository extends JpaRepository<Question, Long>{

    List<Question> findByQuiz(Long idQuiz);
    Question findByIdQuest(Long idQuest);
}
