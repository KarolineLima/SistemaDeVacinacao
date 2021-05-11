package br.edu.ifpb.projeto.vacinacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.projeto.vacinacao.model.Usuario;
import br.edu.ifpb.projeto.vacinacao.service.LoginService;

@RestController
@RequestMapping({"/login"})
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	
	@GetMapping("/{usuario}")
	public Usuario login(@PathVariable("usuario") Usuario usuario) {
		Usuario user = loginService.findByLogin(usuario);
		
		if(user != null) {
			return user;
		}
		
	 return null;	
	}
}
