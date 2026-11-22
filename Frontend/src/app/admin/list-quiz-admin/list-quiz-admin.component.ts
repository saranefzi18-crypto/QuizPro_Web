import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Quiz } from '../../models/quiz';
import { QuizService } from '../../service/quiz.service';

@Component({
  selector: 'app-list-quiz-admin',
  imports: [CommonModule],
  templateUrl: './list-quiz-admin.component.html',
  styleUrl: './list-quiz-admin.component.css'
})
export class ListQuizAdminComponent implements OnInit {
  quizList: Quiz[] = [];

  constructor(private quizService: QuizService) {}

  ngOnInit(): void {
    this.charger();
  }

  accepter(idQuiz: number): void {
    this.changerStatut(idQuiz, 'Acceptée');
  }

  refuser(idQuiz: number): void {
    this.changerStatut(idQuiz, 'Refusée');
  }

  changerStatut(idQuiz: number, statut: string): void {
    this.quizService.changerStatut(idQuiz, statut).subscribe({
      next: () => this.charger(),
      error: (err) => console.error("Erreur de changement de statut :", err)
    });
  }

  charger(): void {
    this.quizService.getQuizList().subscribe({
      next: (data) => this.quizList = data,
      error: (err) => console.error("Erreur de chargement des quiz :", err)
    });
  }
}
