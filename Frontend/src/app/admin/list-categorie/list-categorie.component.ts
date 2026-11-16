import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { Categorie } from '../../models/categorie';
import { CategorieService } from '../../service/categorie.service';

@Component({
  selector: 'app-list-categorie',
  imports: [CommonModule, RouterModule],
  templateUrl: './list-categorie.component.html',
  styleUrl: './list-categorie.component.css'
})
export class ListCategorieComponent implements OnInit{
  categories: Categorie[] = [];
  
    constructor(private categorieService: CategorieService) {}
  
    ngOnInit(): void {
      this.chargerCategories();
    }
  
    chargerCategories(): void {
      this.categorieService.getAll().subscribe({
        next: (data) => {
          this.categories = data;
          console.log("Categories récupérées avec succès :", data);
        },
        error: (err) => {
          console.error("Erreur lors de la récupération des catégories :", err);
        }
      });
    }
  
    accepter(idCat: number): void {
      this.categorieService.accepterCategorie(idCat).subscribe({
        next: () => {
          alert("Catégorie acceptée !");
          this.chargerCategories();
        },
        error: (err) => {
          console.error(err);
          alert("Erreur lors de l'acceptation !");
        }
      });
    }
  
  refuser(idCat: number): void {
    this.categorieService.refuserCategorie(idCat).subscribe({
      next: () => {
        alert("Catégorie refusée !");
        this.chargerCategories();
      },
      error: (err) => {
        console.error(err);
        alert("Erreur lors du refus !");
      }
    });
  }
}
