package br.edu.ifpb.projeto.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.projeto.vacinacao.model.Vacinacao;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {

}
