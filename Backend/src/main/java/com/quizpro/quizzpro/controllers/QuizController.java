package com.quizpro.quizzpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.services.QuizService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizServ;

    @PostMapping("/createQuiz")
    public Quiz createQ(@RequestBody Quiz q){
        return quizServ.createQuiz(q);
    } 


}
