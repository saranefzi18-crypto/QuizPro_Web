import { Utilisateur } from "./utilisateur";

export class Formateur extends Utilisateur{

    constructor(nom: string, prenom: string, email: string, motdepasse: string, role: string) {
        super(nom, prenom, email, motdepasse, role);
    }
}
