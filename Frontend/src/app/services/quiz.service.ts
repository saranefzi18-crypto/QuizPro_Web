import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
    private baseUrl = 'http://localhost:8081/api/auth';
  

  constructor(public http: HttpClient) {}
  // 1. Récupérer la liste des quiz
  getQuizList(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }
  // 2. Publier un quiz (modifier son statut)
  publierQuiz(id: number): Observable<any> {
    return this.http.put(`${this.baseUrl}/publier/${id}`, {});
  }
}
