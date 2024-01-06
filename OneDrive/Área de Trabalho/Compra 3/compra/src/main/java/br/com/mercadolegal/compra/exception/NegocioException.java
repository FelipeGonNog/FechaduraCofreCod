package br.com.mercadolegal.compra.exception;

public class NegocioException extends RuntimeException {
	
	private static final long serialVersionUID = -919627100325760450L;

	public NegocioException(String mensagem) {
		super(mensagem);
	}

}
