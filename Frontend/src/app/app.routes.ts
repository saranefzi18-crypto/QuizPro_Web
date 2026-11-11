import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
<<<<<<< HEAD
import { AdminpageComponent } from './adminpage/adminpage.component';
import { FormpageComponent } from './formpage/formpage.component';
=======
import { FormateurhomeComponent } from './formateurhome/formateurhome.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  
  {path: 'inscription', component: InscriptionComponent},
  {path: 'login', component: LoginComponent},
<<<<<<< HEAD
=======
  {path: 'formateurhome', component : FormateurhomeComponent},
  {path : 'adminhome', component : AdminhomeComponent}
  
  

>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445

  {path: 'admindashbord', component : AdminpageComponent},
  {path: 'formdashbord', component : FormpageComponent}
  
];
