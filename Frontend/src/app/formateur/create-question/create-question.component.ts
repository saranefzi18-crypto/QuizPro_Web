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

  typeQuest: string = '';
  contenu: string = '';
  duree: number = 0;
  image: string = '';
  document: string = '';
  reponceCorrect: string = '';

  constructor(public route: ActivatedRoute, public questionService: QuestionService) {
    this.route.params.subscribe(
      params => {
        this.idQuiz = params['idQuiz'];
        this.afficherQuestions();
      });
  }


  enregistrerQuestion() {

    let q = new Question(this.typeQuest || 'QCM', this.contenu, this.image || '', this.document || '', this.reponceCorrect || '', this.duree || 1, Number(this.idQuiz));

    if (this.modeModification == false) {
      this.questionService.AjouterQuestion(q).subscribe({
        next: () => {
          alert("Question ajoutée !");
          this.afficherQuestions();
          this.contenu = '';
          this.reponceCorrect = '';
          this.duree = 0;
        },
        error: (err) => {
          console.error(err);
          alert("Erreur lors de l'ajout de la question");
        }
      });
    } else {
      this.questionService.ModifierQuestion(q, this.idQues).subscribe({
        next: () => {
          alert("Question modifiée !");
          this.afficherQuestions();
          this.modeModification = false;
        },
        error: (err) => {
          console.error(err);
          alert("Erreur lors de la modification de la question");
        }
      });
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

    this.modeModification = false;
  }

  afficherQuestions() {
    this.questionService.AfiichList(this.idQuiz).subscribe(
      data => {
        this.questions = data;
      });
  }
}
