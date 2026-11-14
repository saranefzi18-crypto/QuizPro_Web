import { Component } from '@angular/core';
import { Quiz } from '../models/quiz';
import { QuizService } from '../service/quiz.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Categorie } from '../models/categorie';
import { CategorieService } from '../service/categorie.service';


@Component({
  selector: 'app-modif-quiz',
  imports: [FormsModule,CommonModule],
  templateUrl: './modif-quiz.component.html',
  styleUrl: './modif-quiz.component.css'
})
export class ModifQuizComponent {
  quiz : Quiz = new Quiz('','','',0,'',new Date(),0,false,false,'','',0);
  cat : Categorie[]=[];

  constructor(public quizServ :QuizService, public catServ :CategorieService, public router :Router, public route : ActivatedRoute){
    this.route.params.subscribe(params =>{
      const id = params["id"];
      if (id){
        this.quizServ.getQuiz(id).subscribe({
          next : data =>{
            this.quiz.idQuiz=data.idQuiz;
            this.quiz.titre=data.titre;
            this.quiz.description=data.description;
            this.quiz.objectif=data.objectif;
            this.quiz.duree=data.duree;
            this.quiz.dateLimite=data.dateLimite;
            this.quiz.dateCreation=data.dateCreation;
            this.quiz.nbrTentatives=data.nbrTentatives;
            this.quiz.melangeQust=data.melangeQust;
            this.quiz.melangeRep=data.melangeRep;
            this.quiz.typeQuiz=data.typeQuiz;
            this.quiz.statut=data.statut;
            this.quiz.score=data.score;
            this.quiz.idCat=data.categorie.idCat;
          },
          error : err => console.error(err)
        })
      }
      this.catServ.getAllCat().subscribe(data =>{
          this.cat=data;
      })
    })
  }

  enregistrer(){
    this.quizServ.updateQuiz(this.quiz.idQuiz,this.quiz).subscribe(
      ()=> this.router.navigate(['/quiz'])
    )
  }

}