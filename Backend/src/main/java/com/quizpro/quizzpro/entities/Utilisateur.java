package com.quizpro.quizzpro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Column(nullable = false, length = 150)
	protected String nom;
	
	@Column(nullable = false, length = 150)
	protected String prenom;
	
	@Column(nullable = false, length = 200)
	protected String email;
	
	@Column(nullable = false, length = 255)
	protected String motdepasse;
	
	@Column(nullable = false, length = 50)
	protected String role;
	
	public Utilisateur(String nom, String prenom, String email, String motdepasse, String role) {
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.motdepasse=motdepasse;
		this.role=role;
	}

	public Utilisateur(){}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotdepasse() {
		return motdepasse;
	}

	public void setMotdepasse(String motdepasse) {
		this.motdepasse = motdepasse;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
