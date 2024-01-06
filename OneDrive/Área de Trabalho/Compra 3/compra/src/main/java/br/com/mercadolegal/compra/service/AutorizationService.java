package br.com.mercadolegal.compra.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.mercadolegal.compra.repository.UsuarioRepository;

@Service
public class AutorizationService implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	public AutorizationService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails usuDetails =  usuarioRepository.findByNome(username);
		return usuDetails;
	}

}
