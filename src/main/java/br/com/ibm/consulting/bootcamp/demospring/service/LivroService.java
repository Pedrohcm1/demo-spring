package br.com.ibm.consulting.bootcamp.demospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;
import br.com.ibm.consulting.bootcamp.demospring.repository.LivroRepository;

@Component
public class LivroService {
	
	@Autowired
	LivroRepository repository;
	
	public Livro criarLivro(Livro l) {
		return repository.saveAndFlush(l);
	}
	
	public List<Livro> listar() {
		return repository.findAll();
	}
	
	public Livro listarPorId(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<Livro> listarPorTitulo(String titulo) {
		return repository.findAllByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Livro> listarPorAutor(String autor) {
		return repository.findAllByAutorContainingIgnoreCase(autor);
	}
	
	public List<Livro> listarPorAno(String ano) {
		return repository.findAllByAnoContainingIgnoreCase(ano);
	}
	
	public void alterar(long id, Livro novoLivro) {
		var alterado = new Livro(id, novoLivro.getAutor(), novoLivro.getTitulo(), novoLivro.getAnoPublicacao(), novoLivro.getDescricao(), novoLivro.getGenero(), novoLivro.getPedido(), novoLivro.getEstoque());
		repository.saveAndFlush(alterado);
	}
	
	public void excluir(long id) {
		var excluir = new Livro(id, null, null, null, null, null, null, null);
		repository.delete(excluir);
	}
}
