package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")
public class categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCat;

    @Column(length = 100)
    private String nom;

    @Column(length = 255)
    private String description;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    private List<Quiz> quizs;

    protected categorie() {
        // Constructeur requis par JPA.
    }

    public categorie(String nom, String desc) {
        this.nom = nom;
        this.description = description;
    }

    // Getters et Setters
    public int getIdCat() { return idCat; }
    public void setIdCat(int idCat) { this.idCat = idCat; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getdescription() { return description; }
    public void setDesc(String desc) { this.description= desc; }

    public List<Quiz> getQuizs() { return quizs; }
    public void setQuizs(List<Quiz> quizs) { this.quizs = quizs; }
}