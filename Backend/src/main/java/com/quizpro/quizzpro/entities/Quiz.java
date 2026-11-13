package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "quiz")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuiz;

    @Column(length = 100)
    private String titre;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String objectif;

    @Column(length = 255)
    private int duree;

    @Column
    private LocalDate dateLimite;

    @Column
    private LocalDate dateCreation;

    @Column
    private int nbrTentatives;

    @Column
    private boolean melangeQust;

    @Column
    private boolean melangeRep;

    @Column(length = 50)
    private String typeQuiz;

    @Column(length = 20)
    private String statut;

    @Column
    private float score;

    @ManyToOne
    @JoinColumn(name = "id_cat")
    private categorie categorie;

    @ManyToOne
    @JoinColumn(name = "id_admin")
    private Administrateur administrateur;

    @ManyToOne
    @JoinColumn(name = "id_formateur")
    private Formateur formateur;

    public Quiz(String titre, String description, String objectif, int duree, LocalDate dateLimite, 
                LocalDate dateCreation, int nbrTentatives, boolean melangeQust, boolean melangeRep, 
                String typeQuiz, String statut, float score, categorie categorie, 
                Administrateur administrateur, Formateur formateur) {
        this.titre = titre;
        this.description = description;
        this.objectif = objectif;
        this.duree = duree;
        this.dateLimite = dateLimite;
        this.dateCreation = dateCreation;
        this.nbrTentatives = nbrTentatives;
        this.melangeQust = melangeQust;
        this.melangeRep = melangeRep;
        this.typeQuiz = typeQuiz;
        this.statut = statut;
        this.score = score;
        this.categorie = categorie;
        this.administrateur = administrateur;
        this.formateur = formateur;
    }

  
    public Long getIdQuiz() { return idQuiz; }
    public void setIdQuiz(Long idQuiz) { this.idQuiz = idQuiz; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getObjectif() { return objectif; }
    public void setObjectif(String objectif) { this.objectif = objectif; }

    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }

    public LocalDate getDateLimite() { return dateLimite; }
    public void setDateLimite(LocalDate dateLimite) { this.dateLimite = dateLimite; }

    public LocalDate getDateCreation() { return dateCreation; }
    public void setDateCreation(LocalDate dateCreation) { this.dateCreation = dateCreation; }

    public int getNbrTentatives() { return nbrTentatives; }
    public void setNbrTentatives(int nbrTentatives) { this.nbrTentatives = nbrTentatives; }

    public boolean isMelangeQust() { return melangeQust; }
    public void setMelangeQust(boolean melangeQust) { this.melangeQust = melangeQust; }

    public boolean isMelangeRep() { return melangeRep; }
    public void setMelangeRep(boolean melangeRep) { this.melangeRep = melangeRep; }

    public String getTypeQuiz() { return typeQuiz; }
    public void setTypeQuiz(String typeQuiz) { this.typeQuiz = typeQuiz; }

    public String getStatut() { return statut; }
    public void setStatut(String statut) { this.statut = statut; }

    public float getScore() { return score; }
    public void setScore(float score) { this.score = score; } 

    public categorie getCategorie() { return categorie; }
    public void setCategorie(categorie categorie) { this.categorie = categorie; }

    public Administrateur getAdministrateur() { return administrateur; }
    public void setAdministrateur(Administrateur administrateur) { this.administrateur = administrateur; }

    public Formateur getFormateur() { return formateur; }
    public void setFormateur(Formateur formateur) { this.formateur = formateur; }
}