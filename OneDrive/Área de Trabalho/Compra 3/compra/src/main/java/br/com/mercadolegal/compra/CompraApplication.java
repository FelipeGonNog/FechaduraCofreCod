package br.com.mercadolegal.compra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API de compras",
				description = "API compras online para o curso de empregabilidade",
				version = "v1.0"
		)
)
public class CompraApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompraApplication.class, args);
	}

}
