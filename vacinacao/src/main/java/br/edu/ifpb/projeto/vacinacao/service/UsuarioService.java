package br.edu.ifpb.projeto.vacinacao.service;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.projeto.vacinacao.model.Usuario;
import br.edu.ifpb.projeto.vacinacao.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}
	
	
	@Transactional
	public void saveUsuario(Usuario usuario) {
		usuarioRepository.saveAndFlush(usuario);
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> opUsuario = usuarioRepository.findById(id);
		return opUsuario.isPresent() ? opUsuario.get() : null; 
	}
	
	@Transactional
	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public List<Usuario> findAll(){
		return usuarioRepository.findAll();
	}
	

	
}
