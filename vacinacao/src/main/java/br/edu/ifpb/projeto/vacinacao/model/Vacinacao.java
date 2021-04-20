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
	@OneToOne
	private Vacina vacina;
	@OneToOne
	private Usuario usuario;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date primeiraDose;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date segundaDose;
	private String localVacinacao;
	
	
	public Vacinacao() {
	
	}
	
	
	public Vacina getVacina() {
		return vacina;
	}

	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
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
