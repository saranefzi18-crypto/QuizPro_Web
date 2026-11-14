package com.quizpro.quizzpro.services;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.repositories.QuizRepository;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizrepo;

    public Quiz getQuiz(int id) {
        return quizrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz introuvable"));
    }

    @Transactional
    public Quiz modifierQuiz(int id, Quiz quiz) {

        if (!quizrepo.existsById(id)) {
            throw new RuntimeException("Quiz introuvable");
        }

        quiz.setIdQuiz(id);

        return quizrepo.save(quiz);
    }
}