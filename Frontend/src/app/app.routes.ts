import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { FormpageComponent } from './formpage/formpage.component';
import { QuizComponent } from './quiz/quiz.component';
import { ListQuizComponent } from './formateur/list-quiz/list-quiz.component';
import { CreateQuizComponent } from './formateur/create-quiz/create-quiz.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  
  {path: 'inscription', component: InscriptionComponent},
  {path: 'login', component: LoginComponent},

  {path: 'admindashbord', component : AdminpageComponent},

  {path:'form/quiz', component:ListQuizComponent},
  {path : '/quiz/create', component: CreateQuizComponent}
  
];
