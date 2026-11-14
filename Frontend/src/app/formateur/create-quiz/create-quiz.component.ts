import { Component } from '@angular/core';
import { Categorie } from '../../models/categorie';
import { Question } from '../../models/question';
import { QuizService } from '../../services/quiz.service';
import { CategorieService } from '../../service/categorie.service';


@Component({
  selector: 'app-create-quiz',
  imports: [],
  templateUrl: './create-quiz.component.html',
  styleUrl: './create-quiz.component.css'
})
export class CreateQuizComponent {
  categorieList: Categorie[] = [];
  questions: Question[] = [];
  quiz ={titre: '', description: '', objectif: '', duree: 0, dateLimite: '', nbrTentatives: 1, idCat: 0}
  idFormateur!: number;

  constructor(public quizService: QuizService, private catService: CategorieService){
    this.catService.getAll().subscribe(data => {
      this.categorieList = data;
    });
  }

  enregistrerQuiz(){
    if(this.questions.length === 0){
      alert("Ajouter au moins deux questions !");
      return
    }

    const quizDta = {
      
    }
  }
}
