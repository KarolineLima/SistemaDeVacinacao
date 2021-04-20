package br.edu.ifpb.projeto.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.projeto.vacinacao.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
