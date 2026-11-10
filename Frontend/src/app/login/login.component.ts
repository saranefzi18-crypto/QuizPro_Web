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
  password = '';
  message ='';
  user! : Utilisateur;
  constructor(public auth : AuthService, public router: Router){}

  login() {
    this.auth.login({ email : this.email , password: this.password }).subscribe({
      next: res => {
        console.log(res);

        if(this.user.role=="commercial" ){
          this.router.navigate(['']);
        }

        else if(this.user.role=="formateur" ){
          this.router.navigate(['/Formateurhome'])
        }

        else if(this.user.role=="administrateur"){
          this.router.navigate(['/adminhome'])
        }
        
      },
      error: () => {
        this.message = "Ce compte non trouvable";
      }

    });
  }
}
