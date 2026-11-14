import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizService } from '../services/quiz.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-quiz',
  standalone: true,
  imports: [CommonModule,RouterLink],
  templateUrl: './quiz.component.html',
  styleUrl: './quiz.component.css'
})
export class QuizComponent {
  quizList: any[] = [];

  constructor(private quizService: QuizService) {
    this.listerQuiz(); // appel de methode 
  }

  // Méthode de listage
  listerQuiz() {
    this.quizService.getQuizList().subscribe({
      next: (data) => {
        this.quizList = data;
        console.log("Liste de quiz:", data);
      },
      error: (err) => {
        console.error("Erreur de chargement de quiz :", err);
      }
    });
  }

  // Méthode de publication
  publierQuiz(id: number) {
    this.quizService.publierQuiz(id).subscribe({
      next: () => {
        alert("Quiz publié avec succès !");
        this.listerQuiz(); // actualiser tab
      },
      error: (err) => {
        console.error("Erreur lors de la publication du quiz :", err);
      }
    });
  }
}