package br.edu.ifpb.projeto.vacinacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.xml.crypto.Data;

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
		
		//Data dataInicio = calendario.getDataInicio;
		//Data datasFim = calendario.getDataInicio;
		
		List<Vacina> vacinas = vacinaService.findAll();
		
		List<Usuario> usuarios = usuarioService.findAll();
		
		
		for(int v=0; v <= vacinas.size(); v++) {
			
			Vacina vacina = vacinas.get(v);
			int total = vacina.getTotalDoses();
			
			for(int u=0; u <= total; u++) {
				Usuario usuario = usuarios.get(u);
		
				
				if(usuario.getIdade() == "60") {
		
					Vacinacao vacinacao = null;
					
					vacinacao.setUsuario(usuario.getIdUsuario());
					vacinacao.setVacina(vacina.getIdVacina());
					//vacinacao.setPrimeiraDose(data);
					//vacinacao.setLocalVacinacao("");
					
					vacinacaoRepository.saveAndFlush(vacinacao);
	
					
					/*
					 * if(usuario.getPrimeiraDose() == null) { }  -- usuario não tem atributo de doses
					 */			
					
				}
			}
			
			
		}
		
		 

	}
	
	public Vacinacao findById(Long id) {
		Optional<Vacinacao> opVacinacao = vacinacaoRepository.findById(id);
		return opVacinacao.isPresent() ? opVacinacao.get() : null; 
	}
	
	@Transactional
	public void deleteById(Long id) {
		vacinacaoRepository.deleteById(id);
	}
	
	public List<Vacinacao> findAll(){
		return vacinacaoRepository.findAll();
	}
	

	
}
