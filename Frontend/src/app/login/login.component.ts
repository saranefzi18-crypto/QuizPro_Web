import { Component } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Utilisateur } from '../models/utilisateur';


@Component({
  selector: 'app-login',
  imports: [RouterLink,FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email = '';
  motdepasse = '';
  message = '';
  user!: Utilisateur;

  constructor(public auth: AuthService, public router: Router) {}

  login() {this.auth.login({email: this.email, motdepasse: this.motdepasse}).subscribe({
    next: res => {
      console.log('Utilisateur connecté :', res);

      this.user = res;

      if (res.role === "commercial") {
        this.router.navigate(['']);
      }
      else if (res.role === "formateur") {
        this.router.navigate(['/formdashbord']);
      }
      else if (res.role === "administrateur") {
        this.router.navigate(['/admindashbord']);
      }
    },
    error: err => {
      console.log('Erreur login :', err);
      this.message = "Email ou mot de passe incorrect !";
    }
  });
  }
}
