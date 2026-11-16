export class Question {

    idQuest! : number;
    typeQuest : string;
    contenu : string;
    image : string;
    document : string;
    reponceCorrect : string;
    duree : number;
    quiz : { idQuiz : number};

    constructor(typeQuest : string, contenu : string, image : string, document : string, reponceCorrect : string, duree : number, idQuiz : number){
        this.typeQuest=typeQuest;
        this.contenu=contenu;
        this.image=image;
        this.document=document;
        this.reponceCorrect=reponceCorrect;
        this.duree=duree;
        this.quiz={idQuiz : idQuiz}
    }


}
