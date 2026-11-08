package com.quizpro.quizzpro.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name ="administrateur")
public class Administrateur extends Utilisateur{
	
	public Administrateur() {
        super();
    }
	
	public Administrateur(String nom, String prenom, String email, String motdepasse, String role) {
		super(nom, prenom, email, motdepasse, role);
	}
}
