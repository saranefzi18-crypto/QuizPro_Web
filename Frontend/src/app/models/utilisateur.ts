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
<<<<<<< HEAD
=======

>>>>>>> aed2d9bb2be538c5dd5d8e986b460e7e0c2c6445
