package br.edu.ifpb.projeto.vacinacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.projeto.vacinacao.model.Vacinacao;
import br.edu.ifpb.projeto.vacinacao.service.VacinacaoService;

@RestController
@RequestMapping({"/vacinacao"})
public class VacinacaoController {
	@Autowired
	private VacinacaoService vacinacaoService;

	
	@GetMapping
	public ResponseEntity<List<Vacinacao>> findAllVacinacoes(){
		 List<Vacinacao> vacinacoes = vacinacaoService.findAll();
		 return ResponseEntity.ok(vacinacoes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vacinacao> findByIdVacinacao(@PathVariable("id") long id) {
		Vacinacao vacinacao = vacinacaoService.findById(id);
		return ResponseEntity.ok(vacinacao);
	
	}


}
