package br.com.ibm.consulting.bootcamp.demospring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ibm.consulting.bootcamp.demospring.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

	 public List<Livro> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
	 
	 public List<Livro> findAllByAutorContainingIgnoreCase(@Param("autor") String autor);
	 
	 public List<Livro> findAllByAnoContainingIgnoreCase(@Param("ano") String ano);

}
