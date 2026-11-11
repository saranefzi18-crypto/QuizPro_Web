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
      const c =motdepasse[i];
      if(lett.includes(c)){
        this.t1=true;
      }
      if (chif.includes(c)){
        this.t2=true;
      }
    }

<<<<<<< HEAD
    if (this.nom=="" || !lett.includes(this.nom) ){
      this.message="Entrer votre nom et prenom"
=======
    if (this.nom.trim() == "" || !this.nom.split('').every(c => lett.includes(c))){
      this.message = "Entrer votre nom";
>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445
    }

    else if (this.prenom.trim() == "" || !this.prenom.split('').every(c => lett.includes(c))){
      this.message = "Entrer votre prenom";
    }

    else if (this.email == '' || !this.email.includes('@')){
      this.message = "Email invalide";
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
          this.router.navigate(['/login']); 
        }
      },

      error: () => {
        this.message = "Erreur inscription";
      }

    });
    }
  }

}