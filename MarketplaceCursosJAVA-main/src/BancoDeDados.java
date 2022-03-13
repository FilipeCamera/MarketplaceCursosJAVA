
// Classe respons�vel pelo banco de dados dos usu�rios, compras e cursos;

import java.util.ArrayList;

public class BancoDeDados {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Curso> cursos = new ArrayList<Curso>();
	static ArrayList<Compra> compras = new ArrayList<Compra>();
	
	// fun��o que armazena o usu�rio
	public static void armazenarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	// fun��o que retorna os usu�rios que est�o armazenados
	public static ArrayList<Usuario> lerArmazenamentoUsuarios() {
		return usuarios;
	}
	
	// fun��o que armazena o curso
	public static void armazenarCurso(Curso curso)  {
		cursos.add(curso);
	}
	
	// fun��o que retorna os cursos armazenados
	public static ArrayList<Curso> lerArmazenamentoCursos() {
		return cursos;
	}
	
	// fun��o que armazena compra
	public static void armazenarCompra(Compra compra)  {
		compras.add(compra);
	}
	
	// fun��o que retorna os cursos armazenados
	public static ArrayList<Compra> lerArmazenamentoCompras() {
		return compras;
	}
	
}
