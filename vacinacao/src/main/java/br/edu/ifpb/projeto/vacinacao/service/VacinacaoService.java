package br.edu.ifpb.projeto.vacinacao.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

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

		long periodoCalendario = ChronoUnit.DAYS.between(dataInicial, dataFinal);
		
		List<Vacina> vacinas = vacinaService.findAll();
		List<Usuario> usuarios = usuarioService.findAll();

		for (int v = 0; v <= vacinas.size(); v++) {

			Vacina vacina = vacinas.get(v);
			int totalDoses = vacina.getTotalDoses();

			long mediaDosesDiarias = totalDoses/periodoCalendario;
			
			for (int u = 0; u <= totalDoses; u++) {
				Usuario usuario = usuarios.get(u);
				
				if ( usuario.getIdade() >= FaixaEtariaInicial && usuario.getIdade() <= FaixaEtariaFinal ) {
				
					if(usuario.getSenhaVacina() == null) {
						
						Vacinacao vacinacao = new Vacinacao();
					
						String senhaVacina = Long.toString(calendario.getIdCalendarioVacinacao()) +
											 Long.toString(vacina.getIdVacina()) + 
											 Long.toString(vacinacao.getIdVacinacao());
						
						usuario.setSenhaVacina(senhaVacina);

						
						vacinacao.setUsuario(usuario.getIdUsuario());
						vacinacao.setVacina(vacina.getIdVacina());
			
						
						calcularDoses(vacinacao, vacina.getIntervalo(), dataInicial, dataFinal,mediaDosesDiarias);
						
						vacinacaoRepository.saveAndFlush(vacinacao);
						
						//Enviar e-mail
					}
				}
			}

		}

	}

	public Vacinacao calcularDoses(Vacinacao vacinacao, Long intervaloVacina, LocalDate dataInicial,LocalDate dataFinal, long mediaDosesDiarias ) {
	
		
		LocalDate verificaDia = ControleDiarioDoses(mediaDosesDiarias, dataInicial, dataFinal);
		
		vacinacao.setPrimeiraDose(verificaDia);
		
		LocalDate data = dataInicial.plusDays(intervaloVacina);
		vacinacao.setSegundaDose(data);


		return vacinacao;
	}

	public LocalDate ControleDiarioDoses(long mediaDosesDiarias, LocalDate dataInicial, LocalDate dataFinal) { 
		
		int dosesDia  = vacinacaoRepository.totalDosesDia(dataInicial);
		
		if(dosesDia >= mediaDosesDiarias) {				

			
			while(dosesDia >= mediaDosesDiarias) {
				int contador = 1;
				LocalDate dia =  dataInicial.plusDays(contador);

				dosesDia  = vacinacaoRepository.totalDosesDia(dia);
				
				if (dia.isBefore(dataInicial) || dia.isAfter(dataFinal)) {		
					return dia;
				}
				
			}
			
			/*for( int i = 1; i > dosesDia; i++) {
				
				LocalDate dia =  dataInicial.plusDays(i);

				dosesDia  = vacinacaoRepository.totalDosesDia(dia);
				
				if (dia.isBefore(dataInicial) || dia.isAfter(dataFinal)) {		
					return dia;
				}
			}*/
		}
		
		return dataInicial;

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
