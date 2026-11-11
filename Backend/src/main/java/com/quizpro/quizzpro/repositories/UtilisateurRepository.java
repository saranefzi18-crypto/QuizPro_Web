package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quizpro.quizzpro.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
	
	Utilisateur findByEmail(String email);

}
