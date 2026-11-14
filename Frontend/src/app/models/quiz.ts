export class Quiz {
    idQuiz! : number;
    titre : string;
    description : string;
    objectif : string;
    duree : number;
    dateLimite : string;
    dateCreation : Date;
    nbrTentatives : number;
    melangeQust : boolean;
    melangeRep : boolean;
    typeQuiz : string;
    statut : string;
    score : number;
    idCat! : number;

    constructor(titre : string, description : string, objectif : string, duree : number, dateLimite : string, dateCreation : Date, nbrTentatives : number, melangeQust : boolean, melangeRep : boolean, typeQuiz : string, statut : string, score : number){
        this.titre=titre;
        this.description=description;
        this.objectif=objectif;
        this.duree=duree;
        this.dateLimite=dateLimite;
        this.dateCreation=dateCreation;
        this.nbrTentatives=nbrTentatives;
        this.melangeQust=melangeQust;
        this.melangeRep=melangeRep;
        this.typeQuiz=typeQuiz;
        this.statut=statut;
        this.score=score;
    }
}