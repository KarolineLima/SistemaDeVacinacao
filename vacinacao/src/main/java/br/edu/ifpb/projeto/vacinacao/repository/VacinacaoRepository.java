package br.edu.ifpb.projeto.vacinacao.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.ifpb.projeto.vacinacao.model.Vacinacao;


public interface VacinacaoRepository extends JpaRepository<Vacinacao, Long> {
	
	  @Query("select count(*) from Vacinacao v where v.primeiraDose = :dia") 
	  long totalDosesDia(@Param("dia") LocalDate dia);
	 
	  
	  @Query("from Vacinacao v join Usuario u on v.senhaVacina = u.senhaVacina where primeiraDose between :data and :dataFimDaSemana ")
	  List<Vacinacao> vacinacaoPrimeiraDose(@Param("data") LocalDate data,
			  							 @Param("dataFimDaSemana") LocalDate dataFimDaSemana);
	  
	  @Query("from Vacinacao v join Usuario u on v.senhaVacina = u.senhaVacina where segundaDose between :data and :dataFimDaSemana ")
	  List<Vacinacao> vacinacaoSegundaDose(@Param("data") LocalDate data,
			  							 @Param("dataFimDaSemana") LocalDate dataFimDaSemana);
	  
	  @Query("select count(*) from Vacinacao")
	  int totalVacinacoes();
}
