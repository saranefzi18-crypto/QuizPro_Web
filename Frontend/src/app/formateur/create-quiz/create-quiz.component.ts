import { Component } from '@angular/core';
import { Categorie } from '../../models/categorie';
import { Question } from '../../models/question';
import { CategorieService } from '../../service/categorie.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { QuestionService } from '../../service/question.service';
import { Router } from '@angular/router';
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
  quiz = { titre: '', description: '', objectif: '', duree: 15, dateLimite: '', nbrTentatives: 1, typeQuiz: 'Technique', statut: 'En_Attent', idCat: 0 };
  idFormateur!: number;

  constructor(public quizService: QuizService, public catService: CategorieService, public questionService: QuestionService, public router: Router) {
    const savedUser = localStorage.getItem('user');
    if (savedUser) {
      try {
        const user = JSON.parse(savedUser);
        if (user && user.id) {
          this.idFormateur = user.id;
        }
      } catch (e) {
        console.error(e);
      }
    }
    if (!this.idFormateur) {
      this.idFormateur = 2;
    }

    this.catService.getAll().subscribe(data => {
      this.catList = data;
      if (this.catList && this.catList.length > 0) {
        this.quiz.idCat = this.catList[0].idCat;
      }
    });
  }

  enregistrerQuiz() {
    if (!this.quiz.titre.trim()) {
      alert("Veuillez saisir un titre pour le quiz.");
      return;
    }

    let defaultDate = new Date();
    defaultDate.setDate(defaultDate.getDate() + 7);
    let dateLim = this.quiz.dateLimite ? this.quiz.dateLimite : defaultDate.toISOString().slice(0, 10);

    let quizData = {
      titre: this.quiz.titre,
      description: this.quiz.description,
      objectif: this.quiz.objectif,
      duree: this.quiz.duree || 15,
      dateLimite: dateLim,
      dateCreation: new Date().toISOString().slice(0, 10),
      nbrTentatives: this.quiz.nbrTentatives || 1,
      melangeQust: false,
      melangeRep: false,
      typeQuiz: this.quiz.typeQuiz || 'Technique',
      statut: this.quiz.statut || 'En_Attent',
      score: 0,
      categorie: this.quiz.idCat > 0 ? { idCat: this.quiz.idCat } : null,
      formateur: { id: this.idFormateur },
      administrateur: null
    };

    this.quizService.creatQuiz(quizData).subscribe({
      next: (data: any) => {
        this.router.navigate(['/quiz', data.idQuiz, 'questions']);
      },
      error: (err: any) => {
        console.error(err);
        alert("Erreur lors de la création du Quiz");
      }
    });
  }

}
