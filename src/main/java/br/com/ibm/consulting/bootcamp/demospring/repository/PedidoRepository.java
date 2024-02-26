package br.com.ibm.consulting.bootcamp.demospring.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import br.com.ibm.consulting.bootcamp.demospring.domain.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	public List<Pedido> findAllByUsuarioContainingIgnoreCase(@Param("usuario") String usuario);
	
	public List<Pedido> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
	public List<Pedido> findAllByDataContainingIgnoreCase(@Param("data") LocalDateTime data);


}
