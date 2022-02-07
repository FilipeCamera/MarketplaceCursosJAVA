import java.util.ArrayList;
import java.util.Scanner;

public class TesteDeSistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nome;
		String sobrenome;
		String email;
		String senha;
		String cpf;
		String cep;
		String telefone;
		int options;
		boolean ativo = true;
		boolean adm = false;

		UsuarioAuth autenticacao;

		Scanner input = new Scanner(System.in);
		autenticacao = new UsuarioAuth();

		System.out.print("Digite o seu nome: \t");
		nome = input.nextLine();

		System.out.print("Digite o seu sobrenome: \t");
		sobrenome = input.nextLine();

		System.out.print("Digite o seu email: \t");
		email = input.nextLine();

		System.out.print("Digite o seu senha: \t");
		senha = input.nextLine();

		System.out.print("Digite o seu cpf: \t");
		cpf = input.nextLine();

		System.out.print("Digite o seu cep: \t");
		cep = input.nextLine();

		System.out.print("Digite o seu telefone: \t");
		telefone = input.nextLine();

		// Caso de uso - registrar usuário
		autenticacao.registrar(nome, sobrenome, email, senha, telefone, cpf, cep);

		// Caso de uso - autenticação do usuário
		autenticacao.login(email, senha);

		// Caso de uso - desconectar
		autenticacao.desconectar();
		
		//Caso de uso - listar usuários -> Perfil Adm
		Usuario admin = new Usuario("Root", "Admin", "admin@gmail.com", "root123", "99999999", "12345678900", "44444444", true, false);
		BancoDeDados.armazenarUsuario(admin);
		
		autenticacao.login("admin@gmail.com", "root123");
		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();

		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getAdmin() == true && usuarios.get(i).getAutenticado() == true) {
				
				adm = true;
			}
		}

		if(adm) {
			System.out.println(usuarios);

		} else {
			System.out.println("Usuário não é administrador!");
		}

	}

}
