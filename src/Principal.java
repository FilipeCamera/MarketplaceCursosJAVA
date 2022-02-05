import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input;

		String nome;
		String sobrenome;
		String email;
		String senha;
		String cpf;
		String cep;
		String telefone;
		int options;
		boolean ativo = true;

		UsuarioAuth autenticacao;

		input = new Scanner(System.in);
		autenticacao = new UsuarioAuth();
		

		while(ativo) {

			System.out.print("====== \t Menu principal \t =====\n\n");
			System.out.print("\t 0 - Registrar \n");
			System.out.print("\t 1 - Login \n");
			System.out.print("\t 2 - Ver usuários \n");
			System.out.print("\t 3 - Sair \n");
			System.out.print("\n\nEscolha sua opção: ");
			options = input.nextInt();
			
			System.out.print("\n\n");
			switch(options) {
			case 0:
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

				autenticacao.registrar(nome, sobrenome, email, senha, telefone, cpf, cep);
				break;
			case 1:
				System.out.print("Digite o seu email: ");
				email = input.nextLine();

				System.out.print("Digite o seu senha: ");
				senha = input.nextLine();

				autenticacao.login(email, senha);
				break;

			case 2:
				ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();
				System.out.println(usuarios);
				
				break;

			case 3:
				ativo = false;
				break;
			}

		}
		System.out.print("====== \t Muito Obrigado por usar nossa plataforma \t =====\n\n");
	}

}
