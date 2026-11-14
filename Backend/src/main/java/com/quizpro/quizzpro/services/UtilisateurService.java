package com.quizpro.quizzpro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.quizpro.quizzpro.entities.Utilisateur;
import com.quizpro.quizzpro.repositories.UtilisateurRepository;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utlRepo;

    public List<Utilisateur> getAll() {
        return utlRepo.findAll();
    }

    // actif = false -> désactiver, actif = true -> réactiver
    @Transactional
    public Utilisateur changerEtat(Long id, boolean actif) {
        Utilisateur u = utlRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // On ne désactive pas un administrateur (sinon on risque de bloquer l'accès à l'admin)
        if (!actif && "administrateur".equalsIgnoreCase(u.getRole())) {
            throw new RuntimeException("Impossible de désactiver un compte administrateur");
        }

        u.setActif(actif);
        return utlRepo.save(u);
    }
}
