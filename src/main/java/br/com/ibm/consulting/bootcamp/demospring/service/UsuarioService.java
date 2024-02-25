package br.com.ibm.consulting.bootcamp.demospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ibm.consulting.bootcamp.demospring.domain.Usuario;
import br.com.ibm.consulting.bootcamp.demospring.repository.UsuarioRepository;

@Component
public class UsuarioService {
	
	@Autowired
	UsuarioRepository repository;
	
	public Usuario criarLivro(Usuario l) {
		return repository.saveAndFlush(l);
	}
	
	public List<Usuario> listar() {
		return repository.findAll();
	}
	
	public Usuario obter(long id) {
		return repository.findById(id).orElse(null);
	}
	
	public void alterar(long id, Usuario novoUsuario) {
		var alterado = new Usuario(id, novoUsuario.getNome(), novoUsuario.getTipo(), novoUsuario.getSenha(), novoUsuario.getContato(), novoUsuario.getPedido());
		repository.saveAndFlush(alterado);
	}
	
	public void excluir(long id) {
		var excluir = new Usuario(id, null, null, null, null, null);
		repository.delete(excluir);
	}


}
