package com.quizpro.quizzpro.entities;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name ="formateur")
public class Formateur extends Utilisateur{

	public Formateur() {
        super();
    }
	
	public Formateur(String nom, String prenom, String email, String motdepasse, String role) {
		super(nom, prenom, email, motdepasse, role);
	}

}
