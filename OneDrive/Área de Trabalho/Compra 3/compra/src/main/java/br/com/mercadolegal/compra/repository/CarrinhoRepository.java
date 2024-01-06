package br.com.mercadolegal.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mercadolegal.compra.entidade.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {

}
