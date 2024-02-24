package br.com.ibm.consulting.bootcamp.demospring.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Estoque {

    private Long estoque;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "estoque", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("estoque")
    private List<Livro> livro;

    public Estoque(Long estoque, List<Livro> livro) {
        this.estoque = estoque;
        this.livro = livro;
    }

    public Long getEstoque() {
        return estoque;
    }

    public void setEstoque(Long estoque) {
        this.estoque = estoque;
    }

    public List<Livro> getLivro() {
        return livro;
    }

    public void setLivro(List<Livro> livro) {
        this.livro = livro;
    }
}