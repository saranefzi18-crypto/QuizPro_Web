import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { QuizService } from '../../service/quiz.service';

@Component({
  selector: 'app-list-quiz',
  imports: [CommonModule, RouterLink],
  templateUrl: './list-quiz.component.html',
  styleUrl: './list-quiz.component.css'
})
export class ListQuizComponent {

  quizList: any[] = [];
  constructor(public quizService :QuizService) {
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
