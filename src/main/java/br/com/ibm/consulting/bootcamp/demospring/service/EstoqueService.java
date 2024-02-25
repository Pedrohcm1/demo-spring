package br.com.ibm.consulting.bootcamp.demospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.consulting.bootcamp.demospring.domain.Estoque;
import br.com.ibm.consulting.bootcamp.demospring.repository.EstoqueRepository;



@Component
public class EstoqueService {
	
	@Autowired
	EstoqueRepository repository;
	
	public Estoque criarLivro(Estoque l) {
		return repository.saveAndFlush(l);
	}
	
	public List<Estoque> listar() {
		return repository.findAll();
	}
	
	public Estoque obter(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void alterar(long id, Estoque novoEstoque) {
		var alterado = new Estoque(novoEstoque.getEstoque(), novoEstoque.getLivro());
		repository.saveAndFlush(alterado);
	}
	
	public void excluir(long id) {
		var excluir = new Estoque(null, null);
		repository.delete(excluir);
	}


}
