package com.quizpro.quizzpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quizpro.quizzpro.entities.Utilisateur;
import com.quizpro.quizzpro.services.AuthService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
	
	@Autowired
	private AuthService utlServ;
	
	public AuthController(AuthService utlServ) {
		this.utlServ=utlServ;
	}
	
	@PostMapping("/inscription")
	public Utilisateur inscrir(@RequestBody Utilisateur utl) {
		return utlServ.inscrire(utl);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Utilisateur utl){
		try {
			return ResponseEntity.ok(utlServ.login(utl));
		} catch (RuntimeException e) {
			// 401 + message lisible par le frontend (compte désactivé, mauvais mot de passe...)
			return ResponseEntity.status(401).body(e.getMessage());
		}
	}

}
