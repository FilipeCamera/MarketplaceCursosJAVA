// Classe responsável pelo banco de dados dos usuários e cursos;


import java.util.ArrayList;

public class BancoDeDados {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Cursos> cursos = new ArrayList<Cursos>();
	
	
	public static void armazenarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static ArrayList<Usuario> lerArmazenamentoUsuarios() {
		return usuarios;
	}
	
	public static void armazenarCurso(Usuario cursos) {
		cursos.add(cursos);
	}
	
	public static ArrayList<Cursos> lerArmazenamentoCursos() {
		return cursos;
	}
	
}
