
// Classe responsável pelo banco de dados dos usuários, compras e cursos;

import java.util.ArrayList;

public class BancoDeDados {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Curso> cursos = new ArrayList<Curso>();
	static ArrayList<Compra> compras = new ArrayList<Compra>();
	
	// função que armazena o usuário
	public static void armazenarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	// função que retorna os usuários que estão armazenados
	public static ArrayList<Usuario> lerArmazenamentoUsuarios() {
		return usuarios;
	}
	
	// função que armazena o curso
	public static void armazenarCurso(Curso curso)  {
		cursos.add(curso);
	}
	
	// função que retorna os cursos armazenados
	public static ArrayList<Curso> lerArmazenamentoCursos() {
		return cursos;
	}
	
	// função que armazena compra
	public static void armazenarCompra(Compra compra)  {
		compras.add(compra);
	}
	
	// função que retorna os cursos armazenados
	public static ArrayList<Compra> lerArmazenamentoCompras() {
		return compras;
	}
	
}
