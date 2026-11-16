package com.quizpro.quizzpro.services;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Question;
import com.quizpro.quizzpro.repositories.QuestionRepository;

@Service
public class QuestService {

    private QuestionRepository quesRepo;

    public QuestService(QuestionRepository quesRepo) {
        this.quesRepo = quesRepo;
    }

    @Transactional
    public Question ajouter(Question ques) {
        return quesRepo.save(ques);
    }

    @Transactional
    public Question modifierQues(Long id, Question ques) {
        Question q = quesRepo.findByIdQuest(id);
        if (q == null) {
            throw new RuntimeException("Question introuvable");
        }
        q.setTypeQuest(ques.getTypeQuest());
        q.setContenu(ques.getContenu());
        q.setImage(ques.getImage());
        q.setDocument(ques.getDocument());
        q.setReponceCorrect(ques.getReponceCorrect());
        q.setDuree(ques.getDuree());

        return quesRepo.save(q);
    }

    @Transactional
    public void supprimerQuestion(Long id) {
        Question q = quesRepo.findByIdQuest(id);
        if (q == null) {
            throw new RuntimeException("Question introuvable");
        }
        quesRepo.delete(q);
    }

    @Transactional
    public List<Question> listerQuestions(int idQuiz) {
        return quesRepo.findByQuiz_IdQuiz(idQuiz);
    }

}