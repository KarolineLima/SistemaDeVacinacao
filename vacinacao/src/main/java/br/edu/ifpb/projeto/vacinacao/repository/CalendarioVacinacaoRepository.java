package br.edu.ifpb.projeto.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.projeto.vacinacao.model.CalendarioVacinacao;

public interface CalendarioVacinacaoRepository extends JpaRepository<CalendarioVacinacao, Long> {

}
