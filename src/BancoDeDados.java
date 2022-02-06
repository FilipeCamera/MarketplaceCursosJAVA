// Classe responsável pelo banco de dados dos usuários e cursos;


import java.util.ArrayList;

public class BancoDeDados {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Curso> cursos = new ArrayList<Curso>();
	
	
	public static void armazenarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static ArrayList<Usuario> lerArmazenamentoUsuarios() {
		return usuarios;
	}
	
	public static void armazenarCurso(Curso curso)  {
		cursos.add(curso);
	}
	
	public static ArrayList<Curso> lerArmazenamentoCursos() {
		return cursos;
	}
	
}
