import { Component } from '@angular/core';
import { Categorie } from '../../models/categorie';
import { Question } from '../../models/question';
import { CategorieService } from '../../service/categorie.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { QuestionService } from '../../service/question.service';
import { Router, RouterLink } from '@angular/router';
import { QuizService } from '../../service/quiz.service';


@Component({
  selector: 'app-create-quiz',
  imports: [CommonModule, FormsModule],
  templateUrl: './create-quiz.component.html',
  styleUrl: './create-quiz.component.css'
})
export class CreateQuizComponent {
  catList: Categorie[] = [];
  questions: Question[] = [];
  quiz ={titre: '', description: '', objectif: '', duree: 0, dateLimite: '', nbrTentatives: 1, typeQuiz: '', statut: 'En_Attent', idCat: 0}
  idFormateur!: number;

  constructor(public quizService: QuizService, public catService: CategorieService,  public questionService: QuestionService, public router : Router){
    this.catService.getAll().subscribe(data => {
      this.catList = data;
    });
  }

  enregistrerQuiz() {

    let quizData = {
      titre: this.quiz.titre,
      description: this.quiz.description,
      objectif: this.quiz.objectif,
      duree: this.quiz.duree,
      dateLimite: this.quiz.dateLimite,
      dateCreation: new Date().toISOString().slice(0, 10),
      nbrTentatives: this.quiz.nbrTentatives,
      typeQuiz: this.quiz.typeQuiz,
      statut: this.quiz.statut,
      score: 0,
      categorie: { idCat: this.quiz.idCat },
      formateur: { id: this.idFormateur },
      administrateur: null
    };

    this.quizService.creatQuiz(quizData).subscribe({
      next: (data) => {
        this.router.navigate(['/quiz', data.idQuiz, 'questions']);
      },
      error: (err) => {
        console.log(err);
        alert("Erreur lors de la création du Quiz");
      }
    })
  }

}
