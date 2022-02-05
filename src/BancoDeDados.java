// Classe responsável pelo banco de dados dos usuários e cursos;


import java.util.ArrayList;

public class BancoDeDados {
	static ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	static ArrayList<Object> cursos = new ArrayList<Object>();
	
	
	public static void armazenarUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
	
	public static ArrayList<Usuario> lerArmazenamentoUsuarios() {
		return BancoDeDados.usuarios;
	}
	
}
