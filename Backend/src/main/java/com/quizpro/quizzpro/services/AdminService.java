package com.quizpro.quizzpro.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.quizpro.quizzpro.entities.Utilisateur;
import com.quizpro.quizzpro.repositories.UtilisateurRepository;

@Service
public class AdminService {

    @Autowired
    private UtilisateurRepository utilisateurRepo;

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepo.findAll();
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepo.deleteById(id);
    }
}