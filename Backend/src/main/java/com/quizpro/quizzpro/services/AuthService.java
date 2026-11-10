package com.quizpro.quizzpro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Administrateur;
import com.quizpro.quizzpro.entities.Commercial;
import com.quizpro.quizzpro.entities.Formateur;
import com.quizpro.quizzpro.entities.Utilisateur;
import com.quizpro.quizzpro.repositories.UtilisateurRepository;

@Service
public class AuthService {
	
	@Autowired
	private UtilisateurRepository utlrepo;
	
	@Autowired
    private BCryptPasswordEncoder mopcryp;

	@Transactional
	public Utilisateur inscrire(Utilisateur utl) {
		
		if(utl.getNom() == null || !utl.getNom().matches("^[a-zA-Z]+$")){
			throw new RuntimeException("Le nom doit contenir uniquement des lettres ");
		}

		if(utl.getPrenom() == null || !utl.getPrenom().matches("^[a-zA-Z]+$")){
			throw new RuntimeException("Le prenom doit contenir uniquement des lettres ");
		}

		if (utl.getEmail() == null || !utl.getEmail().matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$")) {
        	throw new RuntimeException("Format d'email invalide");
    	}

		if(utl.getMotdepasse() == null || !utl.getMotdepasse().matches("^[A-Za-z0-9]+$") || utl.getMotdepasse().length()> 8){
			throw new RuntimeException("Mot de passe invalide");
		}

		Utilisateur u = utlrepo.findByEmail(utl.getEmail());

		if(u!=null) {
			throw new RuntimeException("Email déjà utilisé !");
		}

		String mpCryp =mopcryp.encode(utl.getMotdepasse());
		utl.setMotdepasse(mpCryp);

		String role = utl.getRole().toLowerCase();

		Utilisateur n = new Utilisateur();

		if (role.equals("administrateur")){
			n = new Administrateur(utl.getNom(), utl.getPrenom(), utl.getEmail(), mpCryp, "administrateur");
		}

		else if (role.equals("formateur")){
			n = new Formateur(utl.getNom(), utl.getPrenom(), utl.getEmail(), mpCryp, "formateur");
		}

		else if (role.equals("commercial")){
			n = new Commercial(utl.getNom(), utl.getPrenom(), utl.getEmail(), mpCryp, "commercial");
		}

		else {
        	throw new RuntimeException("Role invalide !");
    	}
		return utlrepo.save(n);
	}

	@Transactional
	public Utilisateur login(Utilisateur utl) {

		if (utl == null) {
			throw new RuntimeException("Données de connexion invalides !");
		}

		if (utl.getEmail() == null || utl.getMotdepasse() == null ) {
			throw new RuntimeException("Email et mot de passe requis !");
		}

		Utilisateur u = utlrepo.findByEmail(utl.getEmail().trim());

		if (u == null) {
        	throw new RuntimeException("Email ou mot de passe incorrect !");
    	}

		boolean test= mopcryp.matches(utl.getMotdepasse(), u.getMotdepasse());

		if (!test) {
        	throw new RuntimeException("Email ou mot de passe incorrect !");
    	}
		return u;
	}
}