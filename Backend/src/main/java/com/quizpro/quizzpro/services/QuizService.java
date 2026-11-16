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
    private QuizRepository quizRepo;

    public List<Quiz> getQuizByFormateur(Long formateurId) {
        return quizRepo.findByFormateurId(formateurId);
    }

    public void deleteQuiz(int id) {
        quizRepo.deleteById(id);
    }

    public Quiz createQuiz(Quiz q) {
        if (q.getCategorie() != null && q.getCategorie().getIdCat() <= 0) {
            q.setCategorie(null);
        }
        if (q.getFormateur() != null && q.getFormateur().getId() <= 0) {
            q.setFormateur(null);
        }
        return quizRepo.save(q);
    }

    public Quiz getQuiz(int id) {
        return quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz introuvable"));
    }

    @Transactional
    public Quiz modifierQuiz(int id, Quiz quiz) {
        Quiz q = quizRepo.findById(id).orElseThrow(() -> new RuntimeException("Quiz introuvable"));
        q.setTitre(quiz.getTitre());
        q.setDescription(quiz.getDescription());
        q.setObjectif(quiz.getObjectif());
        q.setDuree(quiz.getDuree());
        q.setDateLimite(quiz.getDateLimite());
        q.setNbrTentatives(quiz.getNbrTentatives());
        q.setMelangeQust(quiz.isMelangeQust());
        q.setMelangeRep(quiz.isMelangeRep());
        q.setTypeQuiz(quiz.getTypeQuiz());
        if (quiz.getStatut() != null) {
            q.setStatut(quiz.getStatut());
        }
        q.setScore(quiz.getScore());
        if (quiz.getCategorie() != null) {
            q.setCategorie(quiz.getCategorie());
        }
        return quizRepo.save(q);
    }

}