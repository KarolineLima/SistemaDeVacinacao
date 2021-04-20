package br.edu.ifpb.projeto.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.projeto.vacinacao.model.Vacina;

public interface VacinaRepository extends JpaRepository<Vacina, Long> {

}
