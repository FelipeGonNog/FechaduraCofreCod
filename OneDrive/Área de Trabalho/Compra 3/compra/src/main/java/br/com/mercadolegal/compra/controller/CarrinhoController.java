package br.com.mercadolegal.compra.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mercadolegal.compra.entidade.Carrinho;
import br.com.mercadolegal.compra.pojo.CarrinhoPojo;
import br.com.mercadolegal.compra.repository.CarrinhoRepository;

@RestController
@RequestMapping("/carrinhos")
public class CarrinhoController {
	private final CarrinhoRepository carrinhoRepository;

	public CarrinhoController(CarrinhoRepository carrinhorepository) {
		this.carrinhoRepository = carrinhorepository;
	}
	
	@PostMapping
	public CarrinhoPojo create(@RequestBody CarrinhoPojo carrinhoPojo) {
		return new CarrinhoPojo(carrinhoRepository.save(carrinhoPojo.toEntity()));
	}
	
	@PutMapping
	public CarrinhoPojo update(@RequestBody CarrinhoPojo carrinhoPojo) {
		return new CarrinhoPojo(carrinhoRepository.save(carrinhoPojo.toEntity()));
	}
	
	@DeleteMapping
	public void delete(@PathVariable Long id) {
		carrinhoRepository.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public CarrinhoPojo get(@PathVariable Long id) {
	Optional<Carrinho> carrinhoOptional = carrinhoRepository.findById(id);
	if(carrinhoOptional.isPresent()) {
		return new CarrinhoPojo(carrinhoOptional.get());
	}
	return new CarrinhoPojo();
	}
	
	@GetMapping
	public List<CarrinhoPojo> get(){
		return carrinhoRepository.findAll().stream().map(CarrinhoPojo::new).collect(Collectors.toList());
	}
}
