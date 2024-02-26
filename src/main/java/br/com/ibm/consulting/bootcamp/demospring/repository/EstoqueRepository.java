package br.com.ibm.consulting.bootcamp.demospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibm.consulting.bootcamp.demospring.domain.Estoque;


@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long>{

	public List<Estoque> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	
	public List<Estoque> findAllByCategoriaContainingIgnoreCase(@Param("categoria") String categoria);

}
