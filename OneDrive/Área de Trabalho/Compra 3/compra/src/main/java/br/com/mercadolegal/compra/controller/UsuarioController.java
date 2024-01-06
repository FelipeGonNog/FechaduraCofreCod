package br.com.mercadolegal.compra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolegal.compra.entidade.Usuario;
import br.com.mercadolegal.compra.pojo.UsuarioPojo;
import br.com.mercadolegal.compra.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioRepository usuarioRepository;

	// Injeção de dependencia
	public UsuarioController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping
	@Operation(summary = "Recupera usuários", description = "Recupera todos os usuários cadastratos")
	public ResponseEntity<List<UsuarioPojo>> getAll() {
		List<Usuario> ListUsuario = usuarioRepository.findAll();
		List<UsuarioPojo> listUsuarioPojo = new ArrayList<>();
		for (Usuario usuario : ListUsuario) {
			listUsuarioPojo.add(new UsuarioPojo(usuario));
		}
		return  ResponseEntity.ok(listUsuarioPojo);
	}

	// isso para aparecer o 1 no insomnia no link
	// pega oq tá no insomnia e joga no identificador
	@GetMapping(path = "/{id}")
	public ResponseEntity<UsuarioPojo> get(@PathVariable Long id) {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
		if (usuarioOptional.isPresent()) {
			return ResponseEntity.ok(new UsuarioPojo(usuarioOptional.get()))   ;
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public ResponseEntity<UsuarioPojo> create(@RequestBody UsuarioPojo usuarioPojo) {
		 String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioPojo.getSenha());
		 usuarioPojo.setSenha(encryptedPassword);
		return  new ResponseEntity<UsuarioPojo> (new UsuarioPojo(usuarioRepository.save(usuarioPojo.toEntity())),
				                               HttpStatus.CREATED );
	}

	@PutMapping
	public  ResponseEntity<UsuarioPojo> update(@RequestBody UsuarioPojo usuarioPojo) {
		return  ResponseEntity.ok( new UsuarioPojo(usuarioRepository.save(usuarioPojo.toEntity())));

	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	
}