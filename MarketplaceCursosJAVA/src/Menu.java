import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

// Classe Menu - responsável pela interação com o usuário contendo 10 funcionalidades indo de 0 a 9

public class Menu {

	// função que irá exibir o menu
	public void exibirMenu() {
		int options;
		boolean ativo = true;

		UsuarioAuth autenticacao;

		Scanner entrada = new Scanner(System.in);
		autenticacao = new UsuarioAuth();
		
		// Estado inicial do usuário;
		Usuario usuario = null;

		
		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();
		ArrayList<Curso> cursos = BancoDeDados.lerArmazenamentoCursos();

		while (ativo) {
			
			System.out.print("====== \t Menu principal \t ====== \n");
			System.out.print("\t 0 - Registrar \n");
			System.out.print("\t 1 - Login \n");
			System.out.print("\t 2 - Listar cursos \n");
			System.out.print("\t 3 - Criar curso \n");
			System.out.print("\t 4 - Editar curso \n");
			System.out.print("\t 5 - Excluir curso \n");
			System.out.print("\t 6 - Ver usuários \n");
			System.out.print("\t 7 - Comprar curso \n");
			System.out.print("\t 8 - Listar cursos comprados \n");
			System.out.print("\t 9 - Desconectar \n");
			System.out.print("\t 10 - Sair \n");
			System.out.print("\n\nEscolha sua opção: ");
			options = entrada.nextInt();
			entrada.nextLine();

			// caminho que a plataforma irá seguir de acordo com as instruçoes do usuário
			switch (options) {
			case 0:
				
				// apresenta a tela de fazer o registro e retorna o usuário
				usuario = new TelaDeRegistrarOuAutenticarUsuario().fazerRegistro(entrada);
				break;
			case 1:
				
				// apresenta a tela de fazer autenticação e retorna o usuário
				usuario = new TelaDeRegistrarOuAutenticarUsuario().autenticar(entrada);
				break;

			case 2:
				
				// apresenta a tela com os cursos disponíveis na plataforma
				new TelaCursos().listarCursos(entrada);
				break;

			case 3:
				
				// apresenta tela de criar curso
				new TelaCursos().criarCurso(usuario, entrada);
				break;
			case 4:
				
				// apresenta a tela de editar curso
				new TelaCursos().editarCurso(usuario, entrada, cursos);
				break;
			case 5:
				
				// apresenta a tela de excluir curso
				new TelaCursos().excluirCurso(usuario, entrada, cursos);
				break;
			case 6:
				
				// apresenta os usuários e retorna um erro caso não seja administrador
				try {
					new TelaUsuarios().listarUsuarios(usuario, entrada);
				} catch(MensagemError e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7:
				//compra curso
				new TelaCursos().comprarCurso(usuario, entrada, cursos);					
				break;
				
			case 8:
				/*listar cursos comprados
				new TelaCursos().listarCursosComprados(usuario, entrada, cursosAdquiridos);					
				break;	*/
			case 9:
				
				// desconecta o usuário da plataforma
				autenticacao.desconectar();
				break;
			case 10:
				
				// para a aplicação
				ativo = false;
				break;
			}

		}
		System.out.print("====== \t Muito Obrigado por usar nossa plataforma \t =====\n\n");
	}

}
