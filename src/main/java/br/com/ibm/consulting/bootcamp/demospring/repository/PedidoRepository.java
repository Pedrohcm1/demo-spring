package br.com.ibm.consulting.bootcamp.demospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{



}
