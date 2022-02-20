import java.util.ArrayList;

// Classe responsavel pelo registro e autenticação do usuário

public class UsuarioAuth {

	private Usuario usuario;
	private Validacao validacao = new Validacao();
	private ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();

	public UsuarioAuth() {}


	// Função de registar o usuário
	public void registrar(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep) {

		// Validação das informações
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


	// Função de autenticação do usuário
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
	

	// função que faz a desautenticação do usuário
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
		
		// se o usuario não está autenticado retorna essa mensagem
		if(notAutenticado) {
			System.out.println("Usuário não está autenticado");
		}
	}
	
	// função que retorna o usuário autenticado
	public Usuario getUsuario() {
		return usuario;
	}

	
}
