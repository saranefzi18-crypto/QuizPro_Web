import { Component } from '@angular/core';
import { Question } from '../../models/question';
import { ActivatedRoute } from '@angular/router';
import { QuestionService } from '../../service/question.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-create-question',
  imports: [CommonModule, FormsModule],
  templateUrl: './create-question.component.html',
  styleUrl: './create-question.component.css'
})
export class CreateQuestionComponent {
  questions: Question[] = [];
  idQuiz!: number;
  idQues!: number;
  modeModification = false;

  typeQuest: string ='';
  contenu: string ='';
  duree: number = 0;
  image: string ='';
  document: string ='';
  reponseCorrect: string = '';

  constructor(public route: ActivatedRoute, public questionService: QuestionService){
    this.route.params.subscribe(
      params => {
        this.idQuiz=params['idQuiz'];
        this.afficherQuestions();
    });
  }


  enregistrerQuestion(){

    let q = new Question(this.typeQuest, this.contenu, this.image, this.document, this.reponseCorrect, this.duree, this.idQuiz);

    if(this.modeModification == false){
      this.questionService.AjouterQuestion(q).subscribe(()=>{
        alert("Question ajoutée !");
        this.afficherQuestions();
      });
    }
    else{
      this.questionService.ModifierQuestion(q, this.idQues).subscribe(()=> {
        alert("Question modifiée !");
        this.afficherQuestions();
      })
    }
  }

  supprimerQuestion(id: number) {
      this.questionService.SupprimerQuestion(id).subscribe(() => {
        alert("Question supprimée !");
        this.afficherQuestions();
      });
  }

  modifierQuestion(q: Question) {
    this.idQues = q.idQuest;
    this.typeQuest = q.typeQuest;
    this.contenu = q.contenu;
    this.duree = q.duree;
    this.image = q.image;
    this.document = q.document;
    this.reponseCorrect = q.reponseCorrect;

    this.modeModification = true;
  }

  afficherQuestions(){
  this.questionService.AfiichList(this.idQuiz).subscribe(
    data => {
      this.questions =data; 
    });
  }
}
