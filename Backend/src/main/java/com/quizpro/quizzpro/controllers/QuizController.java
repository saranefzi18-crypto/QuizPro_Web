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

    @PostMapping("/create")
    public Quiz createQuiz(@RequestBody Quiz q) {
        return quizService.createQuiz(q);
    }

    @GetMapping("/{idQuiz}")
    public Quiz getQuiz(@PathVariable int idQuiz) {
        return quizService.getQuiz(idQuiz);
    }

    @PutMapping("/modfQuiz/{idQuiz}")
    public Quiz modifierQuiz(@PathVariable int idQuiz, @RequestBody Quiz quiz) {
        return quizService.modifierQuiz(idQuiz, quiz);
    }

    @DeleteMapping("/{id}")
    public void deleteQuiz(@PathVariable int id) {
        quizService.deleteQuiz(id);
    }

}