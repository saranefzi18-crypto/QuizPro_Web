package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuest;

    @Column(length = 50)
    private String typeQuest;

    @Column(length = 255)
    private String contenu;

    @Column(length = 255)
    private String image;

    @Column(length = 255)
    private String document;

    @Column(length = 255)
    private String reponceCorrect;

    private int duree;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
  
    private Quiz quiz;

    public Question(){}

    public Question(String typeQuest, String contenu, String image, String document, String reponceCorrect, int duree, Quiz quiz) {
        this.typeQuest = typeQuest;
        this.contenu = contenu;
        this.image = image;
        this.document = document;
        this.reponceCorrect = reponceCorrect;
        this.duree = duree;
        this.quiz = quiz;
    }

  
    public Long getIdQuest() { return idQuest; }
    public void setIdQuest(Long idQuest) { this.idQuest = idQuest; }

    public String getTypeQuest() { return typeQuest; }
    public void setTypeQuest(String typeQuest) { this.typeQuest = typeQuest; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getDocument() { return document; }
    public void setDocument(String document) { this.document = document; }

    public String getReponceCorrect() { return reponceCorrect; }
    public void setReponceCorrect(String reponceCorrect) { this.reponceCorrect = reponceCorrect; }

    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
}