export class Categorie {
    idCat! : number;
    nom : string;
    desc : string;

    constructor(nom : string, desc : string){
        this.nom=nom;
        this.desc=desc;
    }
}