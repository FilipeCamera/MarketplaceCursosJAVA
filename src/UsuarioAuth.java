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

			this.usuario = new Usuario(nome, sobrenome, email, senha, telefone, cpf, cep, "comum", true);

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
			for(int i = 0; i < this.usuarios.size(); i++) {
				if(this.usuarios.get(i).getEmail().equals(email)) {
					this.usuarios.get(i).setAutenticado(true);
					
					System.out.printf("Login feito com sucesso! \n");
				}
			}
		} catch(MensagemError e) {
			System.out.printf("%s", e.getMessage());

		}
	}

	public void desconectar() {
		for(int i = 0; i < this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getAutenticado() == true) {
				this.usuarios.get(i).setAutenticado(false);
				System.out.println("Você agora está desconectado!");
			} else {
				System.out.println("Você não está autenticado!");
			}
		}


	}
}
