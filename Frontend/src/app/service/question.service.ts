import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Question } from '../models/question';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  private baseUrl = 'http://localhost:8081/api/ques';
  constructor(public http: HttpClient) { }

  AfiichList(idQuiz : number){
    return this.http.get<Question[]>(this.baseUrl + "/listQues/Quiz/" + idQuiz);
  }

  AjouterQuestion(data :any){
    return this.http.post<Question>(this.baseUrl + "/ajout/", data);
  }

  ModifierQuestion(ques: Question, idQues : number){
    return this.http.put<Question>(this.baseUrl + "/mod/" + idQues, ques);
  }

  SupprimerQuestion(idQues: number){
    return this.http.delete<any>(this.baseUrl + "/" + idQues);
  }

}
