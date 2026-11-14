package com.quizpro.quizzpro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")

public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCat;

    @Column(length = 100)
    private String nom;

    @Column(length = 255)
    private String description;

    @JsonIgnore
    // Pas de cascade : supprimer un thème ne doit jamais supprimer ses quiz
    @OneToMany(mappedBy = "categorie")
    private List<Quiz> quizs;

<<<<<<< HEAD
    public Categorie(String nom, String description) {
=======
    public categorie() {}

    public categorie(String nom, String description) {
>>>>>>> 8238a84f15f69787a9a291d2107702f61c21c8d8
        this.nom = nom;
        this.description = description;
    }

    public Categorie(){}
    
    public int getIdCat() { return idCat; }
    public void setIdCat(int idCat) { this.idCat = idCat; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<Quiz> getQuizs() { return quizs; }
    public void setQuizs(List<Quiz> quizs) { this.quizs = quizs; }
}