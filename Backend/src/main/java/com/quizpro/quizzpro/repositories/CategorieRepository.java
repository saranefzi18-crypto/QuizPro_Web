
package com.quizpro.quizzpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.quizpro.quizzpro.entities.categorie;

public interface CategorieRepository extends JpaRepository<categorie, Integer> {

}