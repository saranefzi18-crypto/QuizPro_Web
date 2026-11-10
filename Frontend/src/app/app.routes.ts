import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { FormateurhomeComponent } from './formateurhome/formateurhome.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  {path: 'inscription', component: InscriptionComponent},
  {path: 'login', component: LoginComponent},
  {path: 'formateurhome', component : FormateurhomeComponent},
  {path : 'adminhome', component : AdminhomeComponent}
  
  


];
