package br.com.ibm.consulting.bootcamp.demospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.consulting.bootcamp.demospring.domain.Estoque;

import br.com.ibm.consulting.bootcamp.demospring.service.EstoqueService;


@RestController
@RequestMapping("/api/estoque")
public class EstoqueController {
	
	@Autowired
	EstoqueService service;
	

	@GetMapping
	public List<Estoque> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Estoque> obter(@PathVariable long id) {
		var estoque = service.obter(id);
		if (estoque != null) {
			return new ResponseEntity<Estoque>(estoque, HttpStatus.OK);
		}
		return new ResponseEntity<Estoque>(estoque, HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> atualizar(@RequestBody Estoque estoque, @PathVariable long id) {
		var estoqueExistente = service.obter(id);
		if (estoqueExistente != null) {
			service.alterar(id, estoque);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		var estoqueExistente = service.obter(id);
		if (estoqueExistente != null) {
			service.excluir(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
