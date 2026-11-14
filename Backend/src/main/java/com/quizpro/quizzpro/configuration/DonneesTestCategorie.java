package com.quizpro.quizzpro.configuration;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.quizpro.quizzpro.entities.Quiz;
import com.quizpro.quizzpro.entities.categorie;
import com.quizpro.quizzpro.repositories.CategorieRepository;
import com.quizpro.quizzpro.repositories.QuizRepository;

/**
 * Données de TEST pour pouvoir tester "supprimer catégorie"
 * sans attendre la partie "ajouter catégorie".
 * A supprimer quand l'ajout de catégorie sera prêt.
 */
@Configuration
public class DonneesTestCategorie {

    @Bean
    CommandLineRunner initCategories(CategorieRepository catRepo, QuizRepository quizRepo) {
        return args -> {
            if (catRepo.count() > 0) return; // déjà des données, on ne fait rien

            categorie produits = catRepo.save(new categorie("Produits", "Connaissance des produits"));
            catRepo.save(new categorie("Services", "Les services proposés"));
            catRepo.save(new categorie("Techniques de vente", "Méthodes de vente"));
            catRepo.save(new categorie("Relation client", "Gestion de la relation client"));

            // Un quiz dans "Produits" pour tester le refus de suppression
            Quiz quiz = new Quiz();
            quiz.setTitre("Quiz produits");
            quiz.setDateCreation(LocalDate.now());
            quiz.setCategorie(produits);
            quizRepo.save(quiz);
        };
    }
}
