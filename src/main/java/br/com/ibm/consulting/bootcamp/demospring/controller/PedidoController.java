package br.com.ibm.consulting.bootcamp.demospring.controller;

import java.time.LocalDateTime;
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

import br.com.ibm.consulting.bootcamp.demospring.domain.Pedido;
import br.com.ibm.consulting.bootcamp.demospring.domain.Usuario;
import br.com.ibm.consulting.bootcamp.demospring.service.PedidoService;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

	@Autowired
	PedidoService service;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido criar(@RequestBody Pedido pedido) {
		return service.criarPedido(pedido);
	}

	@GetMapping
	public List<Pedido> listar() {
		return service.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pedido> obter(@PathVariable long id) {
		var pedido = service.obter(id);
		if (pedido != null) {
			return new ResponseEntity<Pedido>(pedido, HttpStatus.OK);
		}
		return new ResponseEntity<Pedido>(pedido, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/usuario/{usuario}")
	public ResponseEntity<List<Pedido>> getByUsuario(@PathVariable String usuario) {
		return ResponseEntity.ok(service.listarPorUsuario(usuario));
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Pedido>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(service.listarPorTitulo(titulo));
	}
	
	@GetMapping("/data/{data}")
	public ResponseEntity<List<Pedido>> getByData(@PathVariable LocalDateTime data) {
		return ResponseEntity.ok(service.listarPorData(data));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> atualizar(@RequestBody Pedido pedido, @PathVariable long id) {
		var pedidoExistente = service.obter(id);
		if (pedidoExistente != null) {
			service.alterar(id, pedido);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Void> excluir(@PathVariable long id) {
		var pedidoExistente = service.obter(id);
		if (pedidoExistente != null) {
			service.excluir(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
