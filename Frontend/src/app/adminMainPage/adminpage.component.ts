import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AdminService } from '../service/admin.service';
import { Utilisateur } from '../models/utilisateur';

@Component({
  selector: 'app-adminpage',
  imports: [CommonModule],
  templateUrl: './adminpage.component.html',
  styleUrl: './adminpage.component.css'
})
export class AdminpageComponent implements OnInit {

  utilisateurs: Utilisateur[] = [];

  constructor(private adminService: AdminService) { }

  ngOnInit(): void {
    this.chargerUtilisateurs();
  }

  chargerUtilisateurs(): void {
    this.adminService.getAllUtilisateurs().subscribe({
      next: (data) => {
        this.utilisateurs = data;
        console.log('Liste des comptes :', data);
      },
      error: (err) => {
        console.error('Erreur lors du chargement des comptes :', err);
      }
    });
  }

  supprimerCompte(id: number): void {
    this.adminService.deleteUtilisateur(id).subscribe({
      next: () => {
        this.utilisateurs = this.utilisateurs.filter(u => u.id !== id);
        console.log('Compte supprimé avec succès !');
      },
      error: (err) => {
        console.error('Erreur lors de la suppression :', err);
      }
    });
  }

}
