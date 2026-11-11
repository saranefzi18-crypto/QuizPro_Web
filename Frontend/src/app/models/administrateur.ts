import { Utilisateur } from "./utilisateur";

export class  Administrateur extends Utilisateur{

    constructor(nom: string, prenom: string, email: string, motdepasse: string, role: string) {
        super(nom, prenom, email, motdepasse, role);
    }
}