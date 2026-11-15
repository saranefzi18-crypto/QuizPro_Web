import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CategorieService } from '../service/categorie.service';
import { Categorie } from '../models/categorie';

@Component({
  selector: 'app-list-categories',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './list-categories.component.html',
  styleUrl: './list-categories.component.css'
})
export class ListCategoriesComponent implements OnInit {
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
    console.log(`Catégorie acceptée, ID: ${idCat}`);
 alert(`Catégorie (ID: ${idCat}) acceptée avec succès !`);
  }

  refuser(idCat: number): void {
    console.log(`Catégorie refusée, ID: ${idCat!}`);
    alert(`Catégorie (ID: ${idCat}) a été refusée.`);
  }
  
}