package br.edu.ifpb.projeto.vacinacao.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="calendarioVacinacao")
public class CalendarioVacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCalendarioVacinacao;
	
	private List dataPorFaixaEtaria = new ArrayList();
	private boolean obsoleto;

	public CalendarioVacinacao() {
		
	}

	public List getDataPorFaixaEtaria() {
		return dataPorFaixaEtaria;
	}

	public void setDataPorFaixaEtaria(List dataPorFaixaEtaria) {
		this.dataPorFaixaEtaria = dataPorFaixaEtaria;
	}

	public Long getIdCalendarioVacinacao() {
		return idCalendarioVacinacao;
	}

	public void setIdCalendarioVacinacao(Long idCalendarioVacinacao) {
		this.idCalendarioVacinacao = idCalendarioVacinacao;
	}

	public boolean isObsoleto() {
		return obsoleto;
	}

	public void setObsoleto(boolean obsoleto) {
		this.obsoleto = obsoleto;
	}

	
	
}
