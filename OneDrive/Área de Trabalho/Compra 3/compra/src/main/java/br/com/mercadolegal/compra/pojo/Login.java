package br.com.mercadolegal.compra.pojo;

public class Login {

	public Login() {
	}

	public Login(String token) {
		this.token = token;
	}

	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
