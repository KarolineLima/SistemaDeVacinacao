package br.edu.ifpb.projeto.vacinacao.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.projeto.vacinacao.model.Usuario;
import br.edu.ifpb.projeto.vacinacao.model.Vacinacao;
import br.edu.ifpb.projeto.vacinacao.repository.VacinacaoRepository;

@Service
public class VacinacaoService {
	
	@Autowired
	private VacinacaoRepository vacinacaoRepository;

	@Autowired
	public VacinacaoService(VacinacaoRepository vacinacaoRepository) {
		super();
		this.vacinacaoRepository = vacinacaoRepository;
	}
	
	
	@Transactional
	public void saveVacina(Vacinacao vacinacao) {
		vacinacaoRepository.saveAndFlush(vacinacao);
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
