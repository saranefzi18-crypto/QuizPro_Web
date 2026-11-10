export class Utilisateur {

    id!: number;
  nom: string;
  prenom: string;
  email: string;
  motdepasse: string;
  role: string;

  constructor(nom: string, prenom: string, email: string, motdepasse: string, role: string) {
    this.nom = nom;
    this.prenom = prenom;
    this.email = email;
    this.motdepasse = motdepasse;
    this.role = role;
  }
}
