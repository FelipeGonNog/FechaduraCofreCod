package br.com.mercadolegal.compra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import br.com.mercadolegal.compra.entidade.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNomeAndSenha(String nome, String senha);

	public UserDetails findByNome(String nome);

}
