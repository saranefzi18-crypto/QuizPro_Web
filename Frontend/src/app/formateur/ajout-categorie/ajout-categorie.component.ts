import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CategorieService } from '../../service/categorie.service';
import { Categorie } from '../../models/categorie';

@Component({
  selector: 'app-ajout-categorie',
  imports: [CommonModule, FormsModule],
  templateUrl: './ajout-categorie.component.html',
  styleUrl: './ajout-categorie.component.css'
})
export class AjoutCategorieComponent {
    nom: string = '';
    desc: string = '';
    status: string= ''
  
    constructor(private categorieService: CategorieService) {}
  
    ajouter() {
    
      const c = new Categorie(this.nom, this.desc, this.status);
  
      this.categorieService.ajouterCategorie(c).subscribe({
        next: (data) => {
          console.log("Ajout avec succès", data);
          alert("Catégorie ajoutée avec succès !");
          
          // Vider les champs
          this.nom = '';
          this.desc = '';
        },
        error: (err) => {
          console.error("Erreur", err);
          alert("Erreur lors de l'ajout !");
        }
      });
    }
}
