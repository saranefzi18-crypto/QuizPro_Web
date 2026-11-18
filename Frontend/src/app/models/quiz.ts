import { Statut } from "./statut";

export class Quiz {

    idQuiz!: number;
    titre: string;
    description: string;
    objectif: string
    duree: number = 0;
    dateLimite: string;
    dateCreation: string;
    nbrTentatives: number;
    melangeQust: boolean;
    melangeRep: boolean;
    typeQuiz: string;
    statut: any;
    score: number;
    categorie: { idCat: number }
    administrateur: { id: number };
    formateur: { id: number };

    constructor(titre: string, description: string, objectif: string, duree: number, dateLimite: string, dateCreation: string, nbrTentatives: number, melangeQust: boolean, melangeRep: boolean, typeQuiz: string, statut: Statut, score: number, idCat: number, idAdmin: number, idForm: number) {
        this.titre = titre
        this.description = description
        this.objectif = objectif
        this.duree = duree
        this.dateLimite = dateLimite
        this.dateCreation = dateCreation
        this.nbrTentatives = nbrTentatives
        this.melangeQust = melangeQust
        this.melangeRep = melangeRep
        this.typeQuiz = typeQuiz
        this.statut = statut
        this.score = score
        this.categorie = { idCat: idCat }
        this.administrateur = { id: idAdmin }
        this.formateur = { id: idForm }
    }
}
