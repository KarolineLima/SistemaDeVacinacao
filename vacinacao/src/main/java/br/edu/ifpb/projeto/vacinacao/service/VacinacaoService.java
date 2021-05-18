package br.edu.ifpb.projeto.vacinacao.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.projeto.vacinacao.model.CalendarioVacinacao;
import br.edu.ifpb.projeto.vacinacao.model.Usuario;
import br.edu.ifpb.projeto.vacinacao.model.Vacina;
import br.edu.ifpb.projeto.vacinacao.model.Vacinacao;
import br.edu.ifpb.projeto.vacinacao.repository.VacinacaoRepository;

@Service
public class VacinacaoService {

	@Autowired
	private VacinacaoRepository vacinacaoRepository;

	@Autowired
	private VacinaService vacinaService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	public VacinacaoService(VacinacaoRepository vacinacaoRepository) {
		super();
		this.vacinacaoRepository = vacinacaoRepository;
	}

	@Transactional
	public void saveVacinacao(CalendarioVacinacao calendario) {

		LocalDate dataInicial = calendario.getDataInicio();
		LocalDate dataFinal = calendario.getDataFinal();
		int FaixaEtariaInicial = calendario.getFaixaEtariaInicial();
		int FaixaEtariaFinal = calendario.getFaixaEtariaFinal();

		List<Vacina> vacinas = vacinaService.findAll();
		List<Usuario> usuarios = usuarioService.findAll();

		int count = 0;
		
		for (int v = 0; v <= vacinas.size(); v++) {

			Vacina vacina = vacinas.get(v);
			int total = vacina.getTotalDoses();

			for (int u = 0; u <= total; u++) {
				Usuario usuario = usuarios.get(u);
				
				if ( usuario.getIdade() >= FaixaEtariaInicial && usuario.getIdade() <= FaixaEtariaFinal ) {
				
					if(usuario.getSenhaVacina() == null) {

						int media = ControleDiarioDoses(total);
												
						if(count > media) {
							count = 0;	
						}
						count ++;
						
						
						
						
						
						
						
						Vacinacao vacinacao = new Vacinacao();
					
						String senhaVacina = Long.toString(calendario.getIdCalendarioVacinacao()) +
											 Long.toString(vacina.getIdVacina()) + 
											 Long.toString(vacinacao.getIdVacinacao());
						
						usuario.setSenhaVacina(senhaVacina);

						
						vacinacao.setUsuario(usuario.getIdUsuario());
						vacinacao.setVacina(vacina.getIdVacina());
						
						calcularDoses(vacinacao, vacina.getIntervalo(), dataInicial, dataFinal,count);
						
						vacinacaoRepository.saveAndFlush(vacinacao);
					}
				}
			}

		}

	}

	public Vacinacao calcularDoses(Vacinacao vacinacao, Long intervalo, LocalDate dataInicial,LocalDate dataFinal, int dosesDiarias ) {

		LocalDate primeriaDose = vacinacao.getPrimeiraDose(); 
		LocalDate segundaDose = vacinacao.getSegundaDose();
		
		
		
	//	long teste =  Days.daysBetween(ReadableInstant(dataInicial), ReadableInstant(dataFinal));
		
		
		/*
		 * long days = Days.daysBetween(dataInicial, dataFinal);
		 * 
		 * Days.between(dateBefore, dateAfter);
		 * 
		 * 
		 * 
		 * 
		 * 
		 * int dias = Days.daysBetween(dataInicial, dataFinal); int dia =
		 * LocalDateTime.Property(dataInicial, dataFinal);
		 */
		
		
		//int dosesDiaria = vacinacaoRepository.totalDosesDia(dataInicial);
		
		/* Long mediaDosesDiarias = totalDoses/dias;
		 * if(dias)
		 * */
		
		
		 
//		 int dias = dataFinal - dataInicio;

		LocalDate data = dataInicial.plusDays(intervalo);
		vacinacao.setPrimeiraDose(dataInicial);
		vacinacao.setSegundaDose(data);

		// int dias = totalDoses;

		return vacinacao;
	}

	public int ControleDiarioDoses(int totalDoses) {
		int mediaDosesDiarias = totalDoses/dias;
		
		
		return mediaDosesDiarias;
	}
	
	public Vacinacao findById(Long id) {
		Optional<Vacinacao> opVacinacao = vacinacaoRepository.findById(id);
		return opVacinacao.isPresent() ? opVacinacao.get() : null;
	}

	@Transactional
	public void deleteById(Long id) {
		vacinacaoRepository.deleteById(id);
	}

	public List<Vacinacao> findAll() {
		return vacinacaoRepository.findAll();
	}

}
