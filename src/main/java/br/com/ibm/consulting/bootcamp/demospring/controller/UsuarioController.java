package br.com.ibm.consulting.bootcamp.demospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;
import br.com.ibm.consulting.bootcamp.demospring.domain.Usuario;

import br.com.ibm.consulting.bootcamp.demospring.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Usuario criar(@RequestBody Usuario usuario) {
		return service.criarUsuario(usuario);
	}
	
	@GetMapping
	public List<Usuario> listar() {
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obter(@PathVariable long id) {
		var usuario = service.obter(id);
		if (usuario != null) {
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		}
		return new ResponseEntity<Usuario>(usuario, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Usuario>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(service.listarPorNome(nome));
	}
	
	@GetMapping("/tipo/{tipo}")
	public ResponseEntity<List<Usuario>> getByTipo(@PathVariable String tipo) {
		return ResponseEntity.ok(service.listarPorTipo(tipo));
	}
	
	@GetMapping("/pedido/{pedido}")
	public ResponseEntity<List<Usuario>> getByPedido(@PathVariable String pedido) {
		return ResponseEntity.ok(service.listarPorPedido(pedido));
	}
		
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> atualizar(@RequestBody Usuario usuario, @PathVariable long id) {
		var usuarioExistente = service.obter(id);
		if (usuarioExistente != null) {
			service.alterar(id, usuario);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		var usuarioExistente = service.obter(id);
		if (usuarioExistente != null) {
			service.excluir(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
