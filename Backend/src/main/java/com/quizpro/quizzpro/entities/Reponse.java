package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reponse")
public class Reponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRep;

    @Column(length = 255)
    private String contenu;

    @Column(length = 255)
    private String explication;

    private float pointObtenu;

    private LocalDate dateR;

    @ManyToOne
    @JoinColumn(name = "id_quest")
    private Question question;

    public Reponse(String contenu, String explication, float pointObtenu, LocalDate dateR, Question question) {
        this.contenu = contenu;
        this.explication = explication;
        this.pointObtenu = pointObtenu;
        this.dateR = dateR;
        this.question = question;
    }

    public int getIdRep() { return idRep; }
    public void setIdRep(int idRep) { this.idRep = idRep; }

    public String getContenu() { return contenu; }
    public void setContenu(String contenu) { this.contenu = contenu; }

    public String getExplication() { return explication; }
    public void setExplication(String explication) { this.explication = explication; }

    public float getPointObtenu() { return pointObtenu; }
    public void setPointObtenu(float pointObtenu) { this.pointObtenu = pointObtenu; }

    public LocalDate getDateR() { return dateR; }
    public void setDateR(LocalDate dateR) { this.dateR = dateR; }

    public Question getQuestion() { return question; }
    public void setQuestion(Question question) { this.question = question; }
}
