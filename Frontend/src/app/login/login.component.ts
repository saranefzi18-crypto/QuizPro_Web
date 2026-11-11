import { Component } from '@angular/core';
<<<<<<< HEAD
=======

>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445
import { AuthService } from '../service/auth.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { Utilisateur } from '../models/utilisateur';
<<<<<<< HEAD


=======
>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445

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

<<<<<<< HEAD
        this.user=res.user;

        if(this.user.role=="Commercial"){
          this.router.navigate(['']);
        }

        else if(this.user.role=="Formateur" ){
          this.router.navigate(['/formdashbord'])
        }

        else if(this.user.role=="administrateur"){
          this.router.navigate(['/admindashbord'])
=======
        if(this.user.role=="commercial" ){
          this.router.navigate(['']);
        }

        else if(this.user.role=="formateur" ){
          this.router.navigate(['/Formateurhome'])
        }

        else if(this.user.role=="administrateur"){
          this.router.navigate(['/adminhome'])
>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445
        }
        
      },
      error: () => {
        this.message = "Ce compte non trouvable";
      }

    });
  }
}
