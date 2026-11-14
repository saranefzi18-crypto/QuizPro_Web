import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { QuizService } from '../service/quiz.service';
import { Quiz } from '../models/quiz';

@Component({
  selector: 'app-formpage',
  imports: [CommonModule],
  templateUrl: './formpage.component.html',
  styleUrl: './formpage.component.css'
})
export class FormpageComponent implements OnInit {


  quizzes: Quiz[] = [];


  constructor(private quizService: QuizService) { }


  ngOnInit(): void {
    const savedUser = localStorage.getItem('user');

    if (savedUser) {
      const user = JSON.parse(savedUser);
      const formateurId = user.id;

      if (formateurId) {
        this.quizService.getQuizByFormateur(formateurId).subscribe({
          next: (data) => {
            this.quizzes = data;
            console.log('Les quiz du formateur connecté :', data);
          },
          error: (err) => {
            console.error('Erreur lors du chargement des quiz :', err);
          }
        });
      }
    }
  }


  supprimerQuiz(idQuiz: number): void {
    this.quizService.deleteQuiz(idQuiz).subscribe({
      next: () => {
        this.quizzes = this.quizzes.filter(q => q.idQuiz !== idQuiz);
        console.log('Quiz supprimé avec succès !');
      },
      error: (err) => {
        console.error('Erreur lors de la suppression :', err);
      }
    });
  }

}