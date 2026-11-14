import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Quiz } from '../models/quiz';

@Injectable({
  providedIn: 'root'
})
export class QuizService {

  private baseUrl = 'http://localhost:8081/api/quiz';

  constructor(public http: HttpClient) { }

  getQuizList(){
    return this.http.get<Quiz[]>(this.baseUrl + "/list");
  }

  creerQuiz(data: any){
    return this.http.post<Quiz>(this.baseUrl+ "/create" ,data);
  }

  publierQuiz(idQuiz: number){
    return this.http.get<Quiz>(this.baseUrl + "/pubier/"+ idQuiz);
  }

}
