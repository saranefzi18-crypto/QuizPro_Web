import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { FormpageComponent } from './formpage/formpage.component';
import { ModifQuizComponent } from './modif-quiz/modif-quiz.component';
import { Component } from '@angular/core';
import { AjoutCategoriesComponent } from './ajout-categories/ajout-categories.component';
import { ListCategoriesComponent } from './list-categories/list-categories.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  
  {path: 'inscription', component: InscriptionComponent},
  {path: 'login', component: LoginComponent},

  {path: 'admindashbord', component : AdminpageComponent},
  {path: 'formdashbord', component : FormpageComponent},
  { path: 'quiz/modifier/:id', component: ModifQuizComponent },
  {path:'ajoutcategories' , component: AjoutCategoriesComponent},
  {path:'listcategories' , component: ListCategoriesComponent}

];
