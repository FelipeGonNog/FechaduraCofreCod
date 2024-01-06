package br.com.mercadolegal.compra.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mercadolegal.compra.entidade.Produto;

public class ProdutoPojo {
	private long id;
	private String nome;
	private String categoria;
	private double valor;
	
	public ProdutoPojo() {
		
	}
	
	public ProdutoPojo(Produto produto) {
		this.id = produto.getId();
		this.categoria = produto.getCategoria();
		this.nome = produto.getNome();	
		this.valor = produto.getValor();
		}
	
	@JsonIgnore
	public Produto toEntity() {
		Produto produto = new Produto();
		produto.setId(id);
		produto.setNome(nome);
		produto.setCategoria(categoria);
		produto.setValor(valor);
		return produto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}
