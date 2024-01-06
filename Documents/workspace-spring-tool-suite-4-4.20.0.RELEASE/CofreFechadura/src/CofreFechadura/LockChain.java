package CofreFechadura;
	import java.util.Scanner;

	abstract class Cofre {
	  protected String tipo;
	  protected String metodoAbertura;

	  public Cofre(String tipo, String metodoAbertura) {
	    this.tipo = tipo;
	    this.metodoAbertura = metodoAbertura;
	  }

	  public void imprimirInformacoes() {
	    System.out.println("Tipo: " + this.tipo);
	    System.out.println("Metodo de abertura: " + this.metodoAbertura);
	  }
	}

	class CofreDigital extends Cofre {

	  private int senha;

	  public CofreDigital(int senha) {
	    super("Cofre Digital", "Senha");
	    this.senha = senha;
	  }

	  public boolean validarSenha(int confirmacaoSenha) {
	    return confirmacaoSenha == this.senha;
	  }
	}

	class CofreFisico extends Cofre {

	  public CofreFisico() {
	    super("Cofre Fisico", "Chave");
	  }
	}

	public class LockChain {
	  public static void main(String[] args) {
	    // Lê o tipo de cofre (primeira linha da entrada)
	    Scanner scanner = new Scanner(System.in);
	    String tipoCofre = scanner.nextLine();
	    
	    if (tipoCofre.equalsIgnoreCase("digital")) {
	      int senha = Integer.parseInt(scanner.nextLine());
	      int confirmacaoSenha = Integer.parseInt(scanner.nextLine());
	      
	      CofreDigital cofreDigital = new CofreDigital(senha);
	      cofreDigital.imprimirInformacoes();
	      
	      if (cofreDigital.validarSenha(confirmacaoSenha)) {
	        System.out.println("Cofre aberto!");
	      } else {
	        System.out.println("Senha incorreta!");
	      }
	    } else if (tipoCofre.equalsIgnoreCase("fisico")) {
	      CofreFisico cofreFisico = new CofreFisico();
	      cofreFisico.imprimirInformacoes();
	      scanner.close();
	    }
	  }
	}


