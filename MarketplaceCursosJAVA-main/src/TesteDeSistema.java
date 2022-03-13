import java.util.ArrayList;
import java.util.Scanner;

public class TesteDeSistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Usuario usuario;

		ArrayList<Curso> cursos = BancoDeDados.lerArmazenamentoCursos();

		// Carregar banco de dados
		boolean carregado = new LoadingBancoDeDados().carregar();
		System.out.printf("Banco de dados carregado: %s \n", carregado);
		
		//Teste de Cadastrar Usuario
		usuario = new TelaDeRegistrarOuAutenticarUsuario().fazerRegistro(input);


		//Teste de Autenticar Usuário
		usuario = new TelaDeRegistrarOuAutenticarUsuario().autenticar(input);


		//Teste de Mostrar Usuarios da Plataforma - caso for administrador
		try {
			new TelaUsuarios().listarUsuarios(usuario, input);
		} catch(MensagemError e) {
			System.out.println(e.getMessage());
		}

		// Teste de listar, editar e excluir cursos

		new TelaCursos().listarCursos(input, usuario, cursos);

		new TelaCursos().editarCurso(usuario, input, cursos);

		new TelaCursos().excluirCurso(usuario, input, cursos);

	}

}
