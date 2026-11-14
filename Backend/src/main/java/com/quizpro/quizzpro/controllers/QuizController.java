package com.quizpro.quizzpro.controllers;

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

    @GetMapping("/{id}")
    public Quiz getQuiz(@PathVariable int id) {
        return quizService.getQuiz(id);
    }

    @PutMapping("/{id}")
    public Quiz modifierQuiz(@PathVariable int id, @RequestBody Quiz quiz) {
        return quizService.modifierQuiz(id, quiz);
    }
}