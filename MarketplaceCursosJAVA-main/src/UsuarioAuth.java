import java.util.ArrayList;

// Classe responsavel pelo registro e autentica��oo do usuario

public class UsuarioAuth {

	private Usuario usuario;
	private Validacao validacao = new Validacao();
	private ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();

	public UsuarioAuth() {}


	// Fun��o de registar o usuario
	public void registrar(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep) {

		// Valida��o das informa��es
		try {
			this.validacao.validacaoRegistrar(email, senha, cpf, cep, telefone);

			this.usuario = new Usuario(nome, sobrenome, email, senha, telefone, cpf, cep, false, true);

			BancoDeDados.armazenarUsuario(this.usuario);
			System.out.printf("Cadastro feito com sucesso! \n");
		} catch (MensagemError e) {
			// TODO Auto-generated catch block
			System.out.printf("%s", e.getMessage());
		}


	}


	// Fun��o de autentica��o do usuario
	public void login(String email, String senha) {
		try {
			this.validacao.validacaoLogin(email, senha);
			for(Usuario usuario : this.usuarios) {
				if(usuario.getEmail().equals(email)) {
					usuario.setAutenticado(true);
					this.usuario = usuario;
					System.out.printf("Login feito com sucesso! \n");
					
				}
			}
		} catch(MensagemError e) {
			System.out.printf("%s", e.getMessage());
		}
	
	}
	

	// fun��o que faz a desautentica��o do usuario
	public void desconectar() {
		boolean notAutenticado = false;
		for (Usuario usuario : this.usuarios) {
			if(usuario.getAutenticado() == true) {
				usuario.setAutenticado(false);
				notAutenticado = false;
				System.out.println("Você agora está desconectado!");
				return;
			} else {
				notAutenticado = true;
			}
		}
		
		// se o usuario n�o est� autenticado retorna essa mensagem
		if(notAutenticado) {
			System.out.println("Usuario nao esta autenticado");
		}
	}
	
	// fun��o que retorna o usuario autenticado
	public Usuario getUsuario() {
		return usuario;
	}

	
}
