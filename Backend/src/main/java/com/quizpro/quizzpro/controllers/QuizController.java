package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.entities.Statut;
import com.quizpro.quizzpro.services.QuizService;

@RestController
@RequestMapping("/api/auth/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizServ;

    @PostMapping("/create")
    public Quiz createQ(@RequestBody Quiz q){
        return quizServ.createQuiz(q);
    } 

    @GetMapping("/list")
    public List<Quiz> listQuiz(){
        return quizServ.listQuizs();
    }

    @GetMapping("/listAccept")
    public List<Quiz> listQuizAcc(){
        return quizServ.QuizAcceptes();
    }

    @PatchMapping("/modifStat")
    public Quiz modQuiz(@RequestBody Quiz quiz, @RequestBody Statut status){
        return quizServ.updateStatus(quiz, status);
    }


}
