import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-accueil',
  imports: [RouterLink],
  templateUrl: './accueil.component.html',
  styleUrl: './accueil.component.css'
})
export class AccueilComponent {
  annee = new Date().getFullYear();

  // Fonctionnalités principales de la plateforme
  fonctionnalites = [
    { icone: '📝', titre: 'Quiz variés', texte: 'QCM, réponse unique, vrai ou faux et réponse courte.' },
    { icone: '⏱️', titre: 'Durée et échéances', texte: 'Chaque quiz a une durée et une date limite définies.' },
    { icone: '📊', titre: 'Résultats détaillés', texte: 'Score, corrections et explications après chaque quiz.' },
    { icone: '📈', titre: 'Suivi de progression', texte: 'Suivez votre évolution par thème et par période.' }
  ];

  // Thèmes de formation proposés
  themes = ['Produits', 'Services', 'Techniques de vente', 'Relation client'];

  // Les profils d'utilisateurs
  profils = [
    {
      titre: 'Commercial',
      points: ['Répondre aux quiz attribués', 'Consulter ses résultats', 'Suivre sa progression']
    },
    {
      titre: 'Formateur / Responsable',
      points: ['Créer et publier des quiz', 'Affecter les quiz aux équipes', 'Analyser les résultats']
    },
    {
      titre: 'Administrateur',
      points: ['Gérer les comptes et les rôles', 'Gérer les catégories', 'Consulter les statistiques']
    }
  ];
}
