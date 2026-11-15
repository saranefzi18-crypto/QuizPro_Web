package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCat;

    private String nom;
    private String description;
    
    // Attribut status (PENDING, ACCEPTED, REFUSED)
    private String status = "PENDING";

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Quiz> quizs;

    public categorie() {
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Quiz> getQuizs() {
        return quizs;
    }

    public void setQuizs(List<Quiz> quizs) {
        this.quizs = quizs;
    }
}