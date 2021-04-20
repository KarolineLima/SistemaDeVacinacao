package br.edu.ifpb.projeto.vacinacao.model;

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
	
	//private List dataPorFaixaEtaria = new ArrayList();

	public CalendarioVacinacao() {
		
	}

	/*public List getDataPorFaixaEtaria() {
		return dataPorFaixaEtaria;
	}

	public void setDataPorFaixaEtaria(List dataPorFaixaEtaria) {
		this.dataPorFaixaEtaria = dataPorFaixaEtaria;
	}
	*/
	
}
