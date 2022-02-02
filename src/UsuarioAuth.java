
// Classe responsavel pelo registro e autenticação do usuário

public class UsuarioAuth {
	
	private Usuario usuario;
	
	public UsuarioAuth() {}
	
	
	// Função de registar o usuário
	public void registrar(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep) throws Validacao {
		
		// Validação das informações
		if(email.length() == 0) {
			throw new Validacao("Seu email não é válido");
		}
		if(senha.length() == 0 && senha.length() >= 6) {
			throw new Validacao("A senha tem que ser maior que 6 caracteres");
		}
		if(telefone.length() == 0) {
			throw new Validacao("Número de telefone inválido");
		}
		if(cpf.length() == 0) {
			throw new Validacao("CPF inválido");
		}
		if(cep.length() == 0) {
			throw new Validacao("CEP inválido");
		}
		
		// Criar usuário para ser armazenado no banco de dados
		this.usuario = new Usuario(nome, sobrenome, email, senha, telefone, cpf, cep, true);
		
		// Aqui vai chamar o banco de dados e armazernar o usuário
	}
	
	
	// Função de autenticação do usuário
	public void login(String email, String senha) {}
}
