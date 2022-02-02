// Classe do usuário

public class Usuario {
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String telefone;
	private String cpf;
	private String cep;
	private boolean autenticado;
	
	
	public Usuario(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep, boolean autenticado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.autenticado = autenticado;
	}
	
	// Função que retorna os dados do usuário;
	public String toString() {
		return String.format("Dados do usuário: \n nome: %s \t sobrenome: %s \t email: %s \t telefone: %s \t cpf: %s \t cep: %s \t autenticado: %s \n", this.nome, this.sobrenome, this.email, this.telefone, this.cpf, this.cep, this.autenticado);
	}
}
