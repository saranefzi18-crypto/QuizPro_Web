package com.quizpro.quizzpro.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.services.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping("/formateur/{id}")
    public List<Quiz> getQuizByFormateur(@PathVariable Long id) {
        return quizService.getQuizByFormateur(id);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable int id) {
        quizService.deleteQuiz(id);
    }

}