package com.quizpro.quizzpro.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.*;

import com.quizpro.quizzpro.entities.Question;
import com.quizpro.quizzpro.services.QuestService;

@RestController
@RequestMapping("/api/ques")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private QuestService quesServ;

    public QuestionController(QuestService quesServ) {
        this.quesServ = quesServ;
    }

    @GetMapping("/listQues/Quiz/{idQuiz}")
    public List<Question> AffQuestions(@PathVariable int idQuiz) {
        return quesServ.listerQuestions(idQuiz);
    }

    @PostMapping("/ajout")
    public Question ajouterQues(@RequestBody Question ques) {
        return quesServ.ajouter(ques);
    }

    @PutMapping("/mod/{idQues}")
    public Question modfQues(@PathVariable Long idQues, @RequestBody Question q) {
        return quesServ.modifierQues(idQues, q);
    }

    @DeleteMapping("/{idQues}")
    public void delQues(@PathVariable Long idQues) {
        quesServ.supprimerQuestion(idQues);
    }

}