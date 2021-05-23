package br.edu.ifpb.projeto.vacinacao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.projeto.vacinacao.model.Usuario;
import br.edu.ifpb.projeto.vacinacao.repository.UsuarioRepository;

@Service
public class LoginService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public Usuario findByLogin(Usuario usuario) {
		Usuario user = usuarioRepository.findByLogin(usuario.getEmail());
		boolean valido = false;
		if(user != null) {
			if(usuario.getSenha() == user.getSenha()) {
				valido = true;
			}
		}
		
		return valido ? user : null;

	}
}
