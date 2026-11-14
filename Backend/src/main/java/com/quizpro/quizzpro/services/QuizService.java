package com.quizpro.quizzpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.entities.Statut;
import com.quizpro.quizzpro.repositories.QuizRepository;


@Service
public class QuizService {

    @Autowired
    private QuizRepository quizrepo;

    @Transactional
	public Quiz createQuiz(Quiz q){
		return quizrepo.save(q);
	}

    @Transactional
    public List<Quiz> listQuizs(){
        return quizrepo.findAll();
    }

    @Transactional
    public List<Quiz> QuizAcceptes(){
        return quizrepo.findByStatut(Statut.Acceptée);
    }

    @Transactional
    public Quiz updateStatus(Quiz quiz, Statut statut){
        if(quizrepo.findById(quiz.getIdQuiz()) == null){
            throw new RuntimeException("Quiz introuvable");
        }
        quiz.setStatut(statut);
        return quizrepo.save(quiz);
    }

    

}
