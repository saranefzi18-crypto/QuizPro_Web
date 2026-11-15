import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { ListQuizComponent } from './formateur/list-quiz/list-quiz.component';
import { CreateQuizComponent } from './formateur/create-quiz/create-quiz.component';
import { CreateQuestionComponent } from './formateur/create-question/create-question.component';
import { ModifQuizComponent } from './modif-quiz/modif-quiz.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  
  {path: 'inscription', component: InscriptionComponent},
  {path: 'login', component: LoginComponent},

  /*{path: 'admindashbord', component : AdminpageComponent},*/

  {path:'form/quiz', component:ListQuizComponent},
  {path : 'quiz/create', component: CreateQuizComponent},
  { path: 'quiz/:idQuiz/questions', component: CreateQuestionComponent},
  { path:  'quiz//modfQuiz/:idQuiz' , component: ModifQuizComponent},

  
];
