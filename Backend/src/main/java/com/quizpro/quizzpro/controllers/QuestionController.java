package com.quizpro.quizzpro.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizpro.quizzpro.entities.Question;
import com.quizpro.quizzpro.services.QuestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/api/ques")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private QuestService quesServ;

    public QuestionController(QuestService quesServ){
        this.quesServ=quesServ;
    }

    @GetMapping("listQues/Quiz/{idQuiz}")
    public List<Question> AffQuestions(@PathVariable Long idQuiz) {
        return quesServ.listerQuestions(idQuiz);
    }
    

    @PostMapping("/ajout/{idQuiz}")
    public Question ajouterQues(@PathVariable Long idQuiz, @RequestBody Question body) {
       return quesServ.ajouter(idQuiz, body);
    }

    @PutMapping("mod/{idQues}")
    public Question modfQues(@PathVariable Long idQues, @RequestBody Question q) {
       return quesServ.modifierQues(idQues, q);
    }

    @DeleteMapping("/{idQues}")
    public void delQues(@PathVariable Long idQues) {
       quesServ.supprimerQuestion(idQues);
    }
    


}
