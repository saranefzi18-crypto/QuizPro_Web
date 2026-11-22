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
  duree: number =0;
  image: string ='';
  document: string ='';
  reponceCorrect: string = '';

  constructor(public route: ActivatedRoute, public questionService: QuestionService){
    this.route.params.subscribe(
      params => {
        this.idQuiz=Number(params['idQuiz']);
        this.afficherQuestions();
    });
  }


  enregistrerQuestion(){
const dureeNum = Number(this.duree);
    let q = new Question(this.typeQuest, this.contenu, this.image, this.document, this.reponceCorrect, this.duree, this.idQuiz);
console.log("Question envoyée :", q);
if(this.modeModification == false){


  // On enlève quiz et idQuest du JSON envoyé
  const { quiz, idQuest, ...donneesQuestion } = q;

  this.questionService.AjouterQuestion(this.idQuiz, donneesQuestion).subscribe({
        next :(data) => {
          console.log("Question ajoutée :", data);
          alert("Question ajoutée !");
          this.afficherQuestions();
        },
        error: (err) => {
         console.log("Status :", err.status);
        console.log("Erreur détaillée :", err.error);
        console.log("Données envoyées :", q);
        alert("Erreur lors de l'ajout ! Vérifie la console.");
        }
      });
    }
    else{
      this.questionService.ModifierQuestion(q, this.idQues).subscribe(()=> {
        alert("Question modifiée !");
        this.afficherQuestions();
        this.modeModification = false;
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
    this.reponceCorrect = q.reponceCorrect;

    this.modeModification = true;
  }

  afficherQuestions(){
  this.questionService.AfiichList(this.idQuiz).subscribe(
    data => {
      this.questions =data; 
    });
  }

  
}
