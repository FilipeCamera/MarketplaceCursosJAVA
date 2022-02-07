
// Classe responsavel pelo registro e autenticação do usuário

public class UsuarioAuth {
	
	private Usuario usuario;
	private Validacao validacao = new Validacao();
	
	public UsuarioAuth() {}
	
	
	// Função de registar o usuário
	public void registrar(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep) {
		
		// Validação das informações
		try {
			this.validacao.validacaoRegistrar(email, senha, cpf, cep, telefone);
			
			this.usuario = new Usuario(nome, sobrenome, email, senha, telefone, cpf, cep, true);
			
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
			
			System.out.printf("Login feito com sucesso! \n");
		} catch(MensagemError e) {
			System.out.printf("%s", e.getMessage());
			
		}
	}
}
