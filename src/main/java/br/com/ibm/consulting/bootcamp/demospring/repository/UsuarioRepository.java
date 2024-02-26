package br.com.ibm.consulting.bootcamp.demospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.ibm.consulting.bootcamp.demospring.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	public List<Usuario> findAllByTipoContainingIgnoreCase(@Param("tipo") String tipo);
	
	public List<Usuario> findAllByPedidoContainingIgnoreCase(@Param("pedido") String pedido);
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

}
