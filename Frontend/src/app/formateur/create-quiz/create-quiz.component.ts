import { Component } from '@angular/core';
import { Categorie } from '../../models/categorie';
import { Question } from '../../models/question';
import { CategorieService } from '../../service/categorie.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { QuestionService } from '../../service/question.service';
import { Router, RouterLink } from '@angular/router';
import { QuizService } from '../../service/quiz.service';
import { AuthService } from "../../service/auth.service";


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

  constructor(public quizService: QuizService, public catService: CategorieService,  public questionService: QuestionService, public router : Router, public auth: AuthService){
    this.catService.getAll().subscribe(data => {
      this.catList = data;
    });
  }

  enregistrerQuiz() {
    if (!this.auth.userConnecte) {
      alert("Veuillez vous connecter !");
      return;
    }

    this.idFormateur = this.auth.userConnecte.id;

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
      melangeQust: false,
      melangeRep: false,
      score: 0,
      categorie: { idCat: this.quiz.idCat },
      formateur: { id: this.idFormateur },
      administrateur: null
    };

    this.quizService.creatQuiz(quizData).subscribe({
      next: (data1) => {
        console.log("Quiz créé :", data1);
        this.router.navigate(['/quiz', data1.idQuiz, 'questions']);
      },
      error: (err) => {
        console.log("Erreur création quiz :", err);
        alert("Erreur lors de la création du Quiz");
      }
    })
  }

}
