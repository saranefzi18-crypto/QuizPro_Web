import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../service/categorie.service';

@Component({
  selector: 'app-adminpage',
  imports: [],
  templateUrl: './adminpage.component.html',
  styleUrl: './adminpage.component.css'
})
export class AdminpageComponent implements OnInit {
  categories: any[] = [];
  message = '';

  constructor(private catService: CategorieService) {}

  ngOnInit() {
    this.charger();
  }

  charger() {
    this.catService.getAll().subscribe(data => this.categories = data);
  }

  supprimer(cat: any) {
    if (!confirm('Supprimer le thème "' + cat.nom + '" ?')) return;

    this.catService.supprimer(cat.idCat).subscribe({
      next: (msg) => {
        this.message = msg;
        this.categories = this.categories.filter(c => c.idCat !== cat.idCat);
      },
      error: (err) => this.message = err.error || 'Erreur lors de la suppression'
    });
  }
}
