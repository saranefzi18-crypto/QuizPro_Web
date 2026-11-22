import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { ListQuizComponent } from './formateur/list-quiz/list-quiz.component';
import { CreateQuizComponent } from './formateur/create-quiz/create-quiz.component';
import { CreateQuestionComponent } from './formateur/create-question/create-question.component';
import { ModifQuizComponent } from './formateur/modif-quiz/modif-quiz.component';

import { ListCategorieComponent } from './admin/list-categorie/list-categorie.component';
import { AjoutCategorieComponent } from './formateur/ajout-categorie/ajout-categorie.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  
  {path: 'inscription', component: InscriptionComponent},
  {path: 'login', component: LoginComponent},

  {path: 'admindashbord', component : AccueilComponent},

  {path:'ajout' , component: AjoutCategorieComponent},
  {path:'listCat' , component: ListCategorieComponent},


  /*{path: 'admindashbord', component : AdminpageComponent},*/

  {path:'form/quiz', component:ListQuizComponent},
  {path : 'quiz/create', component: CreateQuizComponent},
  { path: 'quiz/:idQuiz/questions', component: CreateQuestionComponent},
  { path:  'quiz/modfQuiz/:idQuiz' , component: ModifQuizComponent},

  
];
