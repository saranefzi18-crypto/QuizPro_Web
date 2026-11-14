package com.quizpro.quizzpro.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.repositories.QuizRepository;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepo;

    public List<Quiz> getQuizByFormateur(Long formateurId) {
        return quizRepo.findByFormateurId(formateurId);
    }

    public void deleteQuiz(int id) {
        quizRepo.deleteById(id);
    }

}