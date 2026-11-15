package com.quizpro.quizzpro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
<<<<<<< HEAD
@Table(name = "categories")
public class categorie {
=======
@Table(name = "categorie")

public class Categorie {
>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    private String nom;
    private String description;
    
    // Attribut status (PENDING, ACCEPTED, REFUSED)
    private String status = "PENDING";

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<Quiz> quizs;

<<<<<<< HEAD
    public categorie() {
    }

    public int getIdCat() {
=======
    public Categorie() {}

    public Categorie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
    public Long getIdCat() {
>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9
        return idCat;
    }

    public void setIdCat(Long idCat) {
        this.idCat = idCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

<<<<<<< HEAD
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
=======
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9
}