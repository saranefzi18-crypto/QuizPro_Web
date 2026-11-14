import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../service/auth.service';



@Component({
  selector: 'app-inscription',
  imports: [RouterLink,FormsModule],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css'
})
export class InscriptionComponent {
  nom = '';
  prenom = '';
  email = '';
  motdepasse = '';
  confirmMotdePasse = '';
  role = '';
  message = '';

  t1 = false;
  t2 = false;

  constructor(public auth: AuthService, public router: Router){}

  register() {
    const motdepasse = this.motdepasse;
    const lett ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    const chif ="0123456789";
    
    this.t1=false;
    this.t2=false;

    for(let i =0 ; i< motdepasse.length ; i++){
      let c =motdepasse[i];
      if(lett.includes(c)){
        this.t1=true;
      }
      if (chif.includes(c)){
        this.t2=true;
      }
    }

    let nomValide = true;
    for (let i = 0; i < this.nom.length; i++) {
      if (!lett.includes(this.nom[i])) {
        nomValide = false;
      }
    }

    let prenomValide = true;
    for (let i = 0; i < this.prenom.length; i++) {
      if (!lett.includes(this.prenom[i])) {
        prenomValide = false;
      }
    }

    if (this.nom.trim() == "" || !nomValide) {
      this.message = "Entrer un nom valide";
    }

    else if (this.prenom.trim() == "" || !prenomValide) {
      this.message = "Entrer un prenom valide";
    }

    else if (this.email == '' || !this.email.includes('@') || !this.email.includes('.')) {
      this.message = "Email invalide. donner votre email sous forme xxxxxx@xxxx.xxxx";
    }

    else if(motdepasse.length > 8 || !this.t1 || !this.t2){
      this.message ="le mots de passe doit etre contient des chiffres, des lettres et de taille ne dépasse pas 8 caractéres!!"
    }

    else if(this.motdepasse !== this.confirmMotdePasse){
      this.message = "Mot de passe non identique";
      return;
    }
    else {
      this.auth.register({nom: this.nom, prenom: this.prenom, email: this.email, motdepasse: this.motdepasse, role: this.role}).subscribe({
      next: () => {
        this.message = "Compte créé avec succès";

        if(this.role == "Commercial"){
          this.router.navigate(['']);
        }

        if(this.role == "Formateur"){
          this.router.navigate(['/formdashbord']); 
        }

        if(this.role == "Administrateur"){
          this.router.navigate(['/admindashbord']); 
        }
      },

      error: () => {
        this.message = "Erreur inscription";
      }

    });
    }
  }
}