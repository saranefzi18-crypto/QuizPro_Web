package com.quizpro.quizzpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Question;
import com.quizpro.quizzpro.repositories.QuestionRepository;

@Service
public class QuestService {

    @Autowired
    private QuestionRepository quesRepo;

    public QuestService(QuestionRepository quesRepo){
        this.quesRepo=quesRepo;
    }

    @Transactional
    public Question ajouter(Question ques){
        return quesRepo.save(ques);
    }

    @Transactional 
    public Question modifierQues(Long id, Question ques) {
        Question q = quesRepo.findByIdQuest(id);
        if(q == null){
            throw new RuntimeException("Question introuvable");
        }
        q.setTypeQuest(ques.getTypeQuest());
        q.setContenu(ques.getContenu());
        q.setImage(ques.getImage());
        q.setDocument(ques.getDocument());
        q.setReponceCorrect(ques.getReponceCorrect());

        return quesRepo.save(q);
    }

    @Transactional
    public void supprimerQuestion(Long id){
        Question q = quesRepo.findByIdQuest(id);
        if(q== null){
            throw new RuntimeException("Question introuvable");
        }
        quesRepo.delete(q);
    }

    @Transactional
    public List<Question> listerQuestions(Long idQuiz) {
        return quesRepo.findByQuiz(idQuiz);
    }

}
