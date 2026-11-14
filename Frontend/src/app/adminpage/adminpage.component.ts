import { Component, OnInit } from '@angular/core';
import { CategorieService } from '../service/categorie.service';
import { UtilisateurService } from '../service/utilisateur.service';

@Component({
  selector: 'app-adminpage',
  imports: [],
  templateUrl: './adminpage.component.html',
  styleUrl: './adminpage.component.css'
})
export class AdminpageComponent implements OnInit {
  categories: any[] = [];
  message = '';

  utilisateurs: any[] = [];
  messageUtl = '';

  constructor(private catService: CategorieService, private utlService: UtilisateurService) {}

  ngOnInit() {
    this.charger();
    this.chargerUtilisateurs();
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

  chargerUtilisateurs() {
    this.utlService.getAll().subscribe(data => this.utilisateurs = data);
  }

  // Désactive un compte actif, ou réactive un compte désactivé
  changerEtat(u: any) {
    const action = u.actif ? 'Désactiver' : 'Réactiver';
    if (!confirm(action + ' le compte de ' + u.prenom + ' ' + u.nom + ' ?')) return;

    const requete = u.actif ? this.utlService.desactiver(u.id) : this.utlService.activer(u.id);

    requete.subscribe({
      next: (maj) => {
        u.actif = maj.actif;
        this.messageUtl = 'Compte ' + (maj.actif ? 'réactivé' : 'désactivé');
      },
      error: (err) => this.messageUtl = typeof err.error === 'string' ? err.error : 'Erreur lors du changement d\'état'
    });
  }
}
