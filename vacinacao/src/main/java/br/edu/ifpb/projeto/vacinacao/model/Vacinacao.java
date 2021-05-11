package br.edu.ifpb.projeto.vacinacao.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vacinacao")
public class Vacinacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVacinacao;
	
	
	private Long vacina;
	
	private Long usuario;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date primeiraDose;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date segundaDose;
	private String localVacinacao;
	
	
	public Vacinacao() {
	
	}


	public Long getIdVacinacao() {
		return idVacinacao;
	}


	public void setIdVacinacao(Long idVacinacao) {
		this.idVacinacao = idVacinacao;
	}


	public Long getVacina() {
		return vacina;
	}


	public void setVacina(Long vacina) {
		this.vacina = vacina;
	}


	public Long getUsuario() {
		return usuario;
	}


	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}


	public Date getPrimeiraDose() {
		return primeiraDose;
	}


	public void setPrimeiraDose(Date primeiraDose) {
		this.primeiraDose = primeiraDose;
	}


	public Date getSegundaDose() {
		return segundaDose;
	}


	public void setSegundaDose(Date segundaDose) {
		this.segundaDose = segundaDose;
	}


	public String getLocalVacinacao() {
		return localVacinacao;
	}


	public void setLocalVacinacao(String localVacinacao) {
		this.localVacinacao = localVacinacao;
	}


}
