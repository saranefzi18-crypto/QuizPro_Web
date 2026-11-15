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

    public QuizService(QuizRepository quizrepo){
        this.quizrepo=quizrepo;
    }

    @Transactional
	public Quiz createQuiz(Quiz q){
		return quizrepo.save(q);
	}

    @Transactional
    public List<Quiz> listQuizs(){
        List<Quiz> liste =quizrepo.findAll();
        return liste;
    }

    @Transactional
    public List<Quiz> QuizAcceptes(){
        return quizrepo.findByStatut(Statut.Acceptée);
    }

    @Transactional
    public Quiz updateStatus(Quiz quiz, Statut statut){
        if(quizrepo.findById(quiz.getIdQuiz()).isEmpty()){
            throw new RuntimeException("Quiz introuvable");
        }
        quiz.setStatut(statut);
        return quizrepo.save(quiz);
    }

    @Transactional
    public Quiz getQuiz(Long id) {
        if (quizrepo.findByIdQuiz(id) == null){
            throw new RuntimeException("Quiz introuvable");
        }
        return quizrepo.findByIdQuiz(id);
    }

    @Transactional 
    public Quiz modifierQuiz(Long id, Quiz quiz) {
        Quiz q = quizrepo.findByIdQuiz(id);
        if(q == null){
            throw new RuntimeException("Quiz introuvable");
        }
        q.setTitre(quiz.getTitre());
        q.setDescription(quiz.getDescription());
        q.setObjectif(quiz.getObjectif());
        q.setDuree(quiz.getDuree());
        q.setDateLimite(quiz.getDateLimite());
        q.setDateCreation(quiz.getDateCreation());
        q.setNbrTentatives(quiz.getNbrTentatives());
        q.setMelangeQust(quiz.isMelangeQust());
        q.setMelangeRep(quiz.isMelangeRep());
        q.setTypeQuiz(quiz.getTypeQuiz());
        q.setStatut(quiz.getStatut());
        q.setScore(quiz.getScore());


        return quizrepo.save(q);
    }

    

}

