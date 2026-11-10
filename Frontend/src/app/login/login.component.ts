import { Component } from '@angular/core';
import { User } from '../models/user';
import { AuthService } from '../service/auth.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';

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
  user! : User;
  constructor(public auth : AuthService, public router: Router){}

  login() {
    this.auth.login({ email : this.email , password: this.password }).subscribe({
      next: res => {
        console.log(res);

        this.auth.userConnect = res.user

        localStorage.setItem('token', res.token);
        this.user=res.user;

        if(this.user.roles=="commercial" && this.user.status_compte=="Activer"){
          this.router.navigate(['/commercial']);
        }

        else if(this.user.roles=="Formateur" && this.user.status_compte=="Activer"){
          this.router.navigate(['/Formateur'])
        }

        else if(this.user.roles=="administrateur"){
          this.router.navigate(['/admin'])
        }
        else{this.message = "Ce compte a été desactiver";}
        
      },
      error: () => {
        this.message = "Ce compte non trouvable";
      }

    });
  }
}
