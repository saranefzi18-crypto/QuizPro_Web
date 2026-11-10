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

        this.user=res.user;

        if(this.user.role=="Commercial"){
          this.router.navigate(['']);
        }

        else if(this.user.role=="Formateur" ){
          this.router.navigate(['/formdashbord'])
        }

        else if(this.user.role=="administrateur"){
          this.router.navigate(['/admindashbord'])
        }
        else{this.message = "Ce compte a été desactiver";}
        
      },
      error: () => {
        this.message = "Ce compte non trouvable";
      }

    });
  }
}
