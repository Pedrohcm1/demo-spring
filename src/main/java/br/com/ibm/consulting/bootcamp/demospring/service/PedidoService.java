package br.com.ibm.consulting.bootcamp.demospring.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.consulting.bootcamp.demospring.domain.Pedido;
import br.com.ibm.consulting.bootcamp.demospring.repository.PedidoRepository;

@Component
public class PedidoService {
	
	@Autowired
	PedidoRepository repository;
	
	public Pedido criarPedido(Pedido l) {
		return repository.saveAndFlush(l);
	}
	
	public List<Pedido> listar() {
		return repository.findAll();
	}
	
	public Pedido obter(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Pedido> listarPorUsuario(String usuario) {
		return repository.findAllByUsuarioContainingIgnoreCase(usuario);
	}
	
	public List<Pedido> listarPorTitulo(String titulo) {
		return repository.findAllByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Pedido> listarPorData(LocalDateTime data) {
		return repository.findAllByDataContainingIgnoreCase(data);
	}
	
	public void alterar(long id, Pedido novoPedido) {
		var alterado = new Pedido(id, novoPedido.getData(), novoPedido.getLivro(), novoPedido.getUsuario());
		repository.saveAndFlush(alterado);
	}
	
	public void excluir(long id) {
		var excluir = new Pedido(id, null, null, null);
		repository.delete(excluir);
	}


}
