package br.com.mercadolegal.compra.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.mercadolegal.compra.exception.NegocioException;
import br.com.mercadolegal.compra.pojo.ProdutoPojo;
import br.com.mercadolegal.compra.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final ProdutoService produtoService;
	
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoPojo>> getAll(){
		return ResponseEntity.ok(produtoService.recuperarProdutos());
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<ProdutoPojo> get(@PathVariable Long id) {
		ProdutoPojo produtoPojo = produtoService.recuperarProduto(id);
		if (produtoPojo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(produtoPojo);		
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody ProdutoPojo produtoPojo) {
		try {
			return new ResponseEntity<ProdutoPojo>( produtoService.salvar(produtoPojo.toEntity()),
									HttpStatus.CREATED);
		} catch (NegocioException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
		}	
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody ProdutoPojo produtoPojo) {
		try {
			return ResponseEntity.ok(produtoService.salvar(produtoPojo.toEntity()));
		} catch (NegocioException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.PRECONDITION_FAILED);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		produtoService.deletarProduto(id);
		return ResponseEntity.ok().build();
	}
	
}
