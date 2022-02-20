import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

	public void exibirMenu() {
		int options;
		boolean ativo = true;

		UsuarioAuth autenticacao;

		Scanner entrada = new Scanner(System.in);
		autenticacao = new UsuarioAuth();
		Usuario usuario = null;

		Usuario administrador = new Usuario("Root", "Admin", "admin@gmail.com", "root123", "99999999", "12345678900",
				"44444444", true, false);
		BancoDeDados.armazenarUsuario(administrador);

		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();
		ArrayList<Curso> cursos = BancoDeDados.lerArmazenamentoCursos();

		while (ativo) {
			// System.out.println(BancoDeDados.lerArmazenamentoUsuarios());
			System.out.print("====== \t Menu principal \t ====== \n");
			System.out.print("\t 0 - Registrar \n");
			System.out.print("\t 1 - Login \n");
			System.out.print("\t 2 - Listar cursos \n");
			System.out.print("\t 3 - Criar curso \n");
			System.out.print("\t 4 - Editar curso \n");
			System.out.print("\t 5 - Excluir curso \n");
			System.out.print("\t 6 - Ver usuários \n");
			System.out.print("\t 7 - Comprar curso \n");
			System.out.print("\t 8 - Desconectar \n");
			System.out.print("\t 9 - Sair \n");
			System.out.print("\n\nEscolha sua opção: ");
			options = entrada.nextInt();
			entrada.nextLine();

			switch (options) {
			case 0:
				usuario = new TelaDeRegistrarOuAutenticarUsuario().fazerRegistro(entrada);
				break;
			case 1:
				usuario = new TelaDeRegistrarOuAutenticarUsuario().autenticar(entrada);
				break;

			case 2:
				new TelaCursos().listarCursos(entrada);
				break;

			case 3:
				new TelaCursos().criarCurso(usuario, entrada);
				break;
			case 4:
				new TelaCursos().editarCurso(usuario, entrada, cursos);
				break;
			case 5:
				new TelaCursos().excluirCurso(usuario, entrada, cursos);
				break;
			case 6:
				try {
					new TelaUsuarios().listarUsuarios(usuario, entrada);
				} catch(MensagemError e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				ativo = false;
				break;
			case 8:
				autenticacao.desconectar();
				break;
			case 9:
				ativo = false;
				break;
			}

		}
		System.out.print("====== \t Muito Obrigado por usar nossa plataforma \t =====\n\n");
	}

}
