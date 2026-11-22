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

  getQuiz(idQuiz : number){
    return this.http.get<Quiz>(this.baseUrl +"/"+ idQuiz);
  }
  creatQuiz(data: any){
    return this.http.post<Quiz>(this.baseUrl+ "/create" ,data);
  }

  publierQuiz(idQuiz: number){
    return this.http.patch<Quiz>(this.baseUrl + "/modifStat/"+ idQuiz +"/publiee", {});
  }

  changerStatut(idQuiz: number, statut: string){
    return this.http.patch<Quiz>(this.baseUrl + "/modifStat/" + idQuiz + "/" + statut, {});
  }

  updateQuiz(idQuiz: number, quiz: Quiz) {
    return this.http.put<any>(this.baseUrl + "/modfQuiz/" + idQuiz, quiz);
  }

  suprQuiz(idQuiz: number){
    return this.http.delete<any>(this.baseUrl + "/del/" + idQuiz)
  }

}

