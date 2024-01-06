package br.com.mercadolegal.compra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercadolegal.compra.entidade.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public List<Produto> findByNome(String nome);

}
