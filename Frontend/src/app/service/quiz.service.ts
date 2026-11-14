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



}