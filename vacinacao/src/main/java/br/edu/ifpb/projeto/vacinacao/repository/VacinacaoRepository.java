package br.edu.ifpb.projeto.vacinacao.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.projeto.vacinacao.model.Vacinacao;

public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
	
	@Query("count(*) from Vacinacao v where v.primeriaDose = :dia")
	int totalDosesDia(@Param("dia") LocalDate dia);
	
}
