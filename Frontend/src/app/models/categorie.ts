export class Categorie {
    idCat! : number;
    nom : String;
    description!: String;
    status :string;
    
    constructor(nom : String, description: String, status :string){
        this.nom=nom;
        this.description=description;
        this.status=status;
    }
}