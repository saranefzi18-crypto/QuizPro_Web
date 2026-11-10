import { Routes } from '@angular/router';
import { AccueilComponent } from './pages/accueil/accueil.component';
import { InscriptionComponent } from './inscription/inscription.component';

export const routes: Routes = [
  { path: '', component: AccueilComponent },
  {path: 'inscription', component: InscriptionComponent},
  /*{path: 'login', component: LoginComponment}*/
  
  


];
