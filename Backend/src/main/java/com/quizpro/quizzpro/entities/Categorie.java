package com.quizpro.quizzpro.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;

    @Column
    private String nom;

    @Column
    private String description;

    // Attribut status (En Attent, Acceptee, refusee)
    @Column
    private String status = "En Attent";

    @JsonIgnore
    @OneToMany(mappedBy = "categorie")
    private List<Quiz> quizs;

    public Categorie() {}

    public Categorie(String nom, String description, String status) {
        this.nom = nom;
        this.description = description;
        this.status=status;
    }

    public Long getIdCat() {
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