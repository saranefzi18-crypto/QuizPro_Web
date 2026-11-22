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
      this.listerQuiz(); 
  }

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
  
  publierQuiz(idQuiz: number) {
    this.quizService.publierQuiz(idQuiz).subscribe({
      next: () => {
        alert("Quiz publié avec succès !");
        this.listerQuiz(); 
      },
      error: (err) => {
        console.error("Erreur lors de la publication du quiz :", err);
      }
    });
  }
    
  supprimerQuiz(idQuiz: number) {
    if (confirm("Voulez-vous vraiment supprimer ce quiz ?")) {

      this.quizService.suprQuiz(idQuiz).subscribe({
        next: () => {
          alert("Quiz supprimé avec succès !");
          this.listerQuiz();
        },
        error: (err) => {
          console.error("Erreur lors de la suppression :", err);
          alert("Erreur lors de la suppression du quiz !");
        }
      });

    }
  }

}
