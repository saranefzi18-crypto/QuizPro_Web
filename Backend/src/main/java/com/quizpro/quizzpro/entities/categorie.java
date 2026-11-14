package com.quizpro.quizzpro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")

public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column(length = 100)
    private String nom;

    @Column(length = 255)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<Quiz> quizs;

    public Categorie() {}

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    
    public Long getIdCat() { return idCat; }
    public void setIdCat(Long idCat) { this.idCat = idCat; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Quiz> getQuizs() { return quizs; }
    public void setQuizs(List<Quiz> quizs) { this.quizs = quizs; }
}