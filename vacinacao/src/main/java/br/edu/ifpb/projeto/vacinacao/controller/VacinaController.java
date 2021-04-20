package br.edu.ifpb.projeto.vacinacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifpb.projeto.vacinacao.model.Vacina;
import br.edu.ifpb.projeto.vacinacao.service.VacinaService;


@RestController
@RequestMapping({"/vacinas"})
public class VacinaController {

	@Autowired
	private VacinaService vacinaService;

	
	@GetMapping
	public ResponseEntity<List<Vacina>> findAllVacina(){
		 List<Vacina> vacinas = vacinaService.findAll();
		 return ResponseEntity.ok(vacinas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vacina> findByIdVacina(@PathVariable("id") long id) {
		Vacina vacinas = vacinaService.findById(id);
		return ResponseEntity.ok(vacinas);
	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Vacina> deleteVacina(@PathVariable("id") long id) {
		if(vacinaService.findById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		vacinaService.deleteById(id);
		return ResponseEntity.noContent().build();
		
	}



	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Vacina> createVacina(/*@Valid*/ @RequestBody Vacina vacinas) {
		System.out.println(vacinas);
		 vacinaService.saveVacina(vacinas);
			return ResponseEntity.ok(vacinas);
	}
	
	@PutMapping(path="/{id}", produces = {"application/json"})
	public ResponseEntity<Vacina> updateVacina(/*@Valid*/ @PathVariable("id") long id, @RequestBody Vacina vacinas) {
		if(vacinaService.findById(id) == null) {
			return ResponseEntity.notFound().build();
		}
		vacinaService.saveVacina(vacinas);
		return ResponseEntity.ok(vacinas);
	}

}
