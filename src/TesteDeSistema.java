import java.util.ArrayList;
import java.util.Scanner;

public class TesteDeSistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Usuario usuario;
		
		
		//Teste de Cadastrar Usuário
		usuario = new TelaDeRegistrarOuAutenticarUsuario().fazerRegistro(input);
		
				
		//Teste de Autenticar Usuário
		usuario = new TelaDeRegistrarOuAutenticarUsuario().autenticar(input);
		
		
		//Teste de Mostrar Usuários da Plataforma - caso for administrador
		try {
			new TelaDeMostrarUsuarios().listarUsuários(usuario, input);
		} catch(MensagemError e) {
			System.out.println(e.getMessage());
		}


	}

}
