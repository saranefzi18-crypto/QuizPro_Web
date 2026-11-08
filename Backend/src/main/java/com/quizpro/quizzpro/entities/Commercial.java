package com.quizpro.quizzpro.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name ="commercial")
public class Commercial extends Utilisateur{
	

	public Commercial() {
        super();
    }

	public Commercial(String nom, String prenom, String email, String motdepasse, String role) {
		super(nom, prenom, email, motdepasse, role);
		
	}
}
