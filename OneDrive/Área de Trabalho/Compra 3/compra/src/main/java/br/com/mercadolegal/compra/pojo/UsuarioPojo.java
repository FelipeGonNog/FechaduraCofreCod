package br.com.mercadolegal.compra.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mercadolegal.compra.entidade.Usuario;

public class UsuarioPojo {
	
	private Long id;
	private String nome;
	private String senha;
	
	public UsuarioPojo(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}
	
	public UsuarioPojo() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	//converter oq tem no pojo para uma entdiade
	@JsonIgnore
	public Usuario toEntity() {
		Usuario usuario = new Usuario();
		usuario.setId(id);
		usuario.setNome(nome);
		usuario.setSenha(senha);
		return usuario;
	}
}
