import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Quiz } from '../../models/quiz';
import { Categorie } from '../../models/categorie';
import { QuizService } from '../../service/quiz.service';
import { CategorieService } from '../../service/categorie.service';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { Statut } from '../../models/statut';

@Component({
  selector: 'app-modif-quiz',
  imports: [FormsModule, CommonModule, RouterLink],
  templateUrl: './modif-quiz.component.html',
  styleUrl: './modif-quiz.component.css'
})
export class ModifQuizComponent {
  quiz: Quiz = new Quiz('', '', '', 0, '', '', 0,false, false, '',Statut.En_Attent, 0, 0, 0, 0);
  cat : Categorie[]=[];

  constructor(public quizServ :QuizService, public catServ :CategorieService, public router :Router, public route : ActivatedRoute){
    this.route.params.subscribe(params =>{
      const id = params["idQuiz"];
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
            this.quiz.categorie = data.categorie ? {idCat: data.categorie.idCat} : {idCat: 0};
          },
          error : err => console.error(err)
        })
      }
      this.catServ.getAll().subscribe(data =>{
          this.cat=data;
      })
    })
  }

  enregistrer(){
    this.quizServ.updateQuiz(this.quiz.idQuiz,this.quiz).subscribe({

      next: () => {
        alert("Quiz modifié avec succès !");
        this.router.navigate(['/formdashbord']);
      },

      error: (err) => {
        console.error(err);
        alert("Erreur lors de la modification !");
      }

    });
  }

}
