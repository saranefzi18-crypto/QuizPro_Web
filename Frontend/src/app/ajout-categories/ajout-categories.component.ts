import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CategorieService } from '../service/categorie.service';
import { Categorie } from '../models/categorie';

@Component({
  selector: 'app-ajout-categories',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './ajout-categories.component.html',
  styleUrl: './ajout-categories.component.css'
})
export class AjoutCategoriesComponent {

  
  nom: string = '';
  desc: string = '';

  constructor(private categorieService: CategorieService) {}

  ajouter() {
  
    const c = new Categorie(this.nom, this.desc);

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