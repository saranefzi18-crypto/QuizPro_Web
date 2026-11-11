package com.quizpro.quizzpro.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nom;

    @Column(length = 70)
    private String prenom;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 255) 
    private String motdepasse;

    @Column(length = 30)
    private String role;

   public Utilisateur() {}

    public Utilisateur(String nom, String prenom, String email, String motdepasse, String role) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motdepasse = motdepasse;
        this.role = role;
    }

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMotdepasse() { return motdepasse; }
    public void setMotdepasse(String motdepasse) { this.motdepasse = motdepasse; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}