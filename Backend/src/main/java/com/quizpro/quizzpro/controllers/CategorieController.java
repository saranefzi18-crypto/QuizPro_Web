package com.quizpro.quizzpro.controllers;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.quizpro.quizzpro.entities.Categorie;
import com.quizpro.quizzpro.services.CategorieService;

@RestController
@RequestMapping("/api/cat")
@CrossOrigin(origins = "http://localhost:4200")
public class CategorieController {

    private CategorieService catServ;

    public CategorieController(CategorieService catServ){
        this.catServ=catServ;
    }

    // 1. Afficher toutes les catégories
    @GetMapping
    public List<Categorie> getAll() {
        return catServ.afficherCategories();
    }

    @GetMapping("/{id}")
    public Categorie getCat(@PathVariable Long id){
        return catServ.getCat(id);
    }

    // 2. Ajouter une catégorie
    @PostMapping("/ajout")
    public Categorie ajouterCategorie(@RequestBody Categorie cat) {
        return catServ.ajouterCategorie(cat);
    }

    @DeleteMapping("del/{idCat}")
    public void supprimerCat(@PathVariable Long idCat){
        catServ.supprimer(idCat);
    }

    // 3. Accepter une catégorie
    @PutMapping("/accepter/{id}")
    public ResponseEntity<Categorie> accepterCategorie(@PathVariable Long id) {
        Categorie updatedCat = catServ.accepterCategorie(id);
        return ResponseEntity.ok(updatedCat);
    }

    // 4. Refuser une catégorie
    @PutMapping("/refuser/{id}")
    public ResponseEntity<Categorie> refuserCategorie(@PathVariable Long id) {
        Categorie updatedCat = catServ.refuserCategorie(id);
        return ResponseEntity.ok(updatedCat);
    }
}

