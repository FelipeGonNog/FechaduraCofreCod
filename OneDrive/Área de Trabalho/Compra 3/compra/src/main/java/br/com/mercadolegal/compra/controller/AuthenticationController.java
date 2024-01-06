package br.com.mercadolegal.compra.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolegal.compra.entidade.Usuario;
import br.com.mercadolegal.compra.infra.security.TokenService;
import br.com.mercadolegal.compra.pojo.Login;
import br.com.mercadolegal.compra.pojo.UsuarioPojo;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

	private final AuthenticationManager authenticationManager;

	private final TokenService tokenService;

	public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService) {
		this.authenticationManager = authenticationManager;
		this.tokenService = tokenService;
	}

	@PostMapping("/login")
	public ResponseEntity<Login> login(@RequestBody UsuarioPojo usuarioPojo) {
		var usernamePassword = new UsernamePasswordAuthenticationToken(usuarioPojo.getNome(), usuarioPojo.getSenha());
		var auth = this.authenticationManager.authenticate(usernamePassword);

		var token = tokenService.generateToken((Usuario) auth.getPrincipal());

		return ResponseEntity.ok(new Login(token));
	}

}
