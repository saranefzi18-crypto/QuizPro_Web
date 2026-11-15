package com.quizpro.quizzpro.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.entities.Statut;
import org.springframework.web.bind.annotation.*;
import com.quizpro.quizzpro.services.QuizService;

@RestController
@RequestMapping("/api/quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizController {

    @Autowired
    private QuizService quizServ;

    public QuizController(QuizService quizServ){
        this.quizServ=quizServ;
    }

    @GetMapping("/list")
    public List<Quiz> listQuiz(){
        return quizServ.listQuizs();
    }

    @GetMapping("/listAccept")
    public List<Quiz> listQuizAcc(){
        return quizServ.QuizAcceptes();
    }

    @PostMapping("/create")
    public Quiz createQ(@RequestBody Quiz q){
        return quizServ.createQuiz(q);
    }

    @PatchMapping("/modifStat")
    public Quiz modQuiz(@RequestBody Quiz quiz, @RequestBody Statut status){
        return quizServ.updateStatus(quiz, status);
    }

    @GetMapping("/{idQuiz}")
    public Quiz getQuiz(@PathVariable Long idQuiz) {
        return quizServ.getQuiz(idQuiz);
    }

    @PutMapping("modfQuiz/{idQuiz}")
    public Quiz modifierQuiz(@PathVariable Long idQuiz, @RequestBody Quiz quiz) {
        return quizServ.modifierQuiz(idQuiz, quiz);
    }

}