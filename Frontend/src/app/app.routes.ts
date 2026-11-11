import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';
import { LoginComponent } from './login/login.component';
import { AdminpageComponent } from './adminpage/adminpage.component';
import { FormpageComponent } from './formpage/formpage.component';
import { CommercialpageComponent } from './commercialpage/commercialpage.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  
  { path: 'inscription', component: InscriptionComponent },
  { path: 'login', component: LoginComponent },

  { path: 'admindashbord', component: AdminpageComponent },
  { path: 'formdashbord', component: FormpageComponent },
  { path: 'commercialdashbord', component: CommercialpageComponent }
  
];
