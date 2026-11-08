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
		Utilisateur u=utlrepo.findByEmail(utl.getEmail());
		
		if(u!=null) {
			throw new RuntimeException("Email déjà utilisé !");
		}

		String mpCryp =mopcryp.encode(utl.getMotdepasse());
		utl.setMotdepasse(mpCryp);

		String role = utl.getRole();

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

}
