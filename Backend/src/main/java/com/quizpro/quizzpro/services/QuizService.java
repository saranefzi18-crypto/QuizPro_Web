package com.quizpro.quizzpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Quiz;
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
    public List<Quiz> QuizAcceptes(){
        return quizrepo.findByStatut("Acceptee");
    }

    @Transactional
    public List<Quiz> Quiz(){
        return quizrepo.findAll();
    }

    @Transactional
    public Quiz updateStatus(Quiz quiz, String statut){
        if(quizrepo.findById(quiz.getIdQuiz()) == null){
            throw new RuntimeException("Quiz introuvable");
        }
        else{
            quiz.setStatut(statut);
        }
        return quizrepo.save(quiz);

    }

    

}
