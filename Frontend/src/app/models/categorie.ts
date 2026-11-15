export class Categorie {
    idCat! : number;
    nom : String;
    description!: String;
    
    constructor(nom : String, description: String){
        this.nom=nom;
        this.description=description;
    }
}