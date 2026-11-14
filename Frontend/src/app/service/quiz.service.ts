import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Quiz } from '../models/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private baseUrl = 'http://localhost:8081/api';

  constructor(public http: HttpClient) { }

  getQuiz(id: number) {
    return this.http.get<any>(this.baseUrl + "/quiz/" + id);
  }

  updateQuiz(id: number, quiz: Quiz) {
    return this.http.put<any>(this.baseUrl + "/quiz/" + id, quiz);
  }
}