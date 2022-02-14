import java.util.Scanner;

public class TelaDeRegistrarOuAutenticarUsuario {
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String cpf;
	private String cep;
	private String telefone;
	private UsuarioAuth autenticacao = new UsuarioAuth();
	private Usuario usuario;
	
	public Usuario fazerRegistro(Scanner entrada) {
		System.out.print("Digite o seu nome: ");
		nome = entrada.nextLine();

		System.out.print("Digite o seu sobrenome: ");
		sobrenome = entrada.nextLine();

		System.out.print("Digite o seu email: ");
		email = entrada.nextLine();

		System.out.print("Digite o seu senha: ");
		senha = entrada.nextLine();

		System.out.print("Digite o seu cpf: ");
		cpf = entrada.nextLine();

		System.out.print("Digite o seu cep: ");
		cep = entrada.nextLine();

		System.out.print("Digite o seu telefone: ");
		telefone = entrada.nextLine();

		autenticacao.registrar(nome, sobrenome, email, senha, telefone, cpf, cep);
		usuario = autenticacao.getUsuario();
		return usuario;
	}
	
	public Usuario autenticar(Scanner entrada) {
		System.out.print("Digite o seu email:\t");
		email = entrada.next();

		System.out.print("Digite o seu senha:\t");
		senha = entrada.next();

		autenticacao.login(email, senha);
		usuario = autenticacao.getUsuario();
		return usuario;
	}
	
	
}
