package com.quizpro.quizzpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
<<<<<<< HEAD

=======
>>>>>>> 7252554583b1a8eadfebf1965e43e1ae6bfd5ee9
	
	@Autowired
	private AuthService utlServ;

	public AuthController(AuthService utlServ) {
		this.utlServ = utlServ;
	}

	@PostMapping("/inscription")
	public Utilisateur inscrir(@RequestBody Utilisateur utl) {
		return utlServ.inscrire(utl);
	}

	@PostMapping("/login")
	public Utilisateur login(@RequestBody Utilisateur utl) {
		return utlServ.login(utl);
	}

}
