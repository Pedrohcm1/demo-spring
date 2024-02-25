package br.com.ibm.consulting.bootcamp.demospring.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String autor;

	private String titulo;

	@JsonProperty("ano_publicacao")
	private String anoPublicacao;

	private String descricao;

	private String genero;

	@ManyToOne
	@JsonIgnoreProperties("livro")
	private Pedido pedido;

	@ManyToOne
	@JsonIgnoreProperties("livro")
	private Estoque estoque;

	public Livro() {

	}

	public Livro(long id, String autor, String titulo, String anoPublicacao, String descricao, String genero,
			Pedido pedido, Estoque estoque) {
		this.id = id;
		this.autor = autor;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
		this.descricao = descricao;
		this.genero = genero;
		this.pedido = pedido;
		this.estoque = estoque;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

}
