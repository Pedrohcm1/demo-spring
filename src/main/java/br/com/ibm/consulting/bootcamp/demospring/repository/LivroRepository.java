package br.com.ibm.consulting.bootcamp.demospring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	Optional<Livro> findByTitulo(long id);

	Optional<Livro> findByAutor(long id);

	Optional<Livro> findByAnoPublicacao(long id);

	

}
