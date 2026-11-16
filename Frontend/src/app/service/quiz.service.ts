import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Quiz } from '../models/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {


  private baseUrl = 'http://localhost:8081/api/quiz';

  constructor(private http: HttpClient) { }


  getQuizByFormateur(formateurId: number): Observable<Quiz[]> {
    return this.http.get<Quiz[]>(`${this.baseUrl}/formateur/${formateurId}`);
  }


  deleteQuiz(idQuiz: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${idQuiz}`);
  }

  creatQuiz(data: any): Observable<Quiz> {
    return this.http.post<Quiz>(`${this.baseUrl}/create`, data);
  }

  getQuiz(idQuiz: number): Observable<Quiz> {
    return this.http.get<Quiz>(`${this.baseUrl}/${idQuiz}`);
  }

  updateQuiz(idQuiz: number, quiz: Quiz): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/modfQuiz/${idQuiz}`, quiz);
  }



}