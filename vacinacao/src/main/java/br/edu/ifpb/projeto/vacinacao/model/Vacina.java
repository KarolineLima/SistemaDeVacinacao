package br.edu.ifpb.projeto.vacinacao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vacina")
public class Vacina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVacina;
	private String nomeVacina; //criar enum
	private int totalDoses;

	
	public Vacina() {
		
	}
	
	public String getNomeVacina() {
		return nomeVacina;
	}
	public void setNomeVacina(String nomeVacina) {
		this.nomeVacina = nomeVacina;
	}
	public int getTotalDoses() {
		return totalDoses;
	}
	public void setTotalDoses(int totalDoses) {
		this.totalDoses = totalDoses;
	}
	
	
	
}
