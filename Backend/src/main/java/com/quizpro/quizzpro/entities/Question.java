package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuest;

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

    private LocalDate duree;

    @ManyToOne
    @JoinColumn(name = "id_quiz")
    private Quiz quiz;

    public Question(String typeQuest, String contenu, String image, String document, String reponceCorrect, LocalDate duree, Quiz quiz) {
        this.typeQuest = typeQuest;
        this.contenu = contenu;
        this.image = image;
        this.document = document;
        this.reponceCorrect = reponceCorrect;
        this.duree = duree;
        this.quiz = quiz;
    }

    // Getters et Setters
    public int getIdQuest() { return idQuest; }
    public void setIdQuest(int idQuest) { this.idQuest = idQuest; }

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

    public LocalDate getDuree() { return duree; }
    public void setDuree(LocalDate duree) { this.duree = duree; }

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }
}