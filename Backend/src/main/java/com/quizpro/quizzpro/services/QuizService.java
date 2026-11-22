package com.quizpro.quizzpro.services;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Categorie;
import com.quizpro.quizzpro.entities.Question;
import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.entities.Statut;
import com.quizpro.quizzpro.repositories.CategorieRepository;
import com.quizpro.quizzpro.repositories.QuestionRepository;
import com.quizpro.quizzpro.repositories.QuizRepository;

@Service
public class QuizService {

    private QuizRepository quizrepo;
    private CategorieRepository catrepo;
    private QuestionRepository quesRepo;

    public QuizService(QuizRepository quizrepo, CategorieRepository catrepo, QuestionRepository quesRepo){
        this.quizrepo=quizrepo;
        this.catrepo=catrepo;
        this.quesRepo=quesRepo;
    }

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
    public Quiz updateStatus(Long idQuiz, Statut statut){
        Quiz quiz = quizrepo.findById(idQuiz).orElseThrow(() -> new RuntimeException("Quiz introuvable"));
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

        Long idCat = quiz.getCategorie().getIdCat();
        Categorie cat = catrepo.findById(idCat).orElseThrow(() -> new RuntimeException("Catégorie introuvable"));
        q.setCategorie(cat);

        return quizrepo.save(q);
    }

    @Transactional
    public void deleteQuiz(Long id) {
        Quiz quiz = quizrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz introuvable"));
        List<Question> questions = quesRepo.findByQuiz_IdQuiz(id);
        quesRepo.deleteAll(questions);
        quizrepo.delete(quiz);
    }
}