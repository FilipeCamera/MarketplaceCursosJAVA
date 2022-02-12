import java.util.ArrayList;
import java.util.UUID;

// Classe do usuário

public class Usuario {
	private String id = UUID.randomUUID().toString();
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String telefone;
	private String cpf;
	private String cep;
	private boolean autenticado;
	private boolean admin;

	public Usuario() {
	};

	public Usuario(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep,
			boolean admin, boolean autenticado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.autenticado = autenticado;
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public String getSenha() {
		return this.senha;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public boolean getAutenticado() {
		return this.autenticado;
	}

	public String getId() {
		return this.id;
	}

	// Função que retorna os dados do usuário;
	public String toString() {
		return String.format(
				"id: %s \t nome: %s \t sobrenome: %s \t email: %s \t telefone: %s \t cpf: %s \t cep: %s \t admin: %s \t autenticado: %s \n",
				this.id, this.nome, this.sobrenome, this.email, this.telefone, this.cpf, this.cep, this.admin,
				this.autenticado);
	}
}
