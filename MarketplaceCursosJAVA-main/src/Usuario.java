import java.util.ArrayList;
import java.util.UUID;

// Classe Usu�rio

public class Usuario {
	private String id = UUID.randomUUID().toString(); // id de identifica��o do usuario
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
	
	// fun��o que retorna o nome
	public String getNome() {
		return this.nome;
	}

	// fun��o que retorna o e-mail
	public String getEmail() {
		return this.email;
	}

	// fun��o que retorna a senha
	public String getSenha() {
		return this.senha;
	}
	
	// fun��o que retorna se o usuario � administrador ou nao
	public boolean getAdmin() {
		return this.admin;
	}
	
	// fun��o que seta se o usuario vai estar autenticado ou nao
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	// fun��o que retorna se o usuario está autenticado
	public boolean getAutenticado() {
		return this.autenticado;
	}
	
	// fun��o que retorna a quatidadde de curso criado pelo usuario
	public int getQuantCursoCriado() {
		int total = 0;
		for(Curso cursoCriado : BancoDeDados.lerArmazenamentoCursos()) {
			if(cursoCriado.getCriador().getId() == id) {
				total++;
			}
		}
		
		return total;
	}

	// fun��o que retorna o ID do usuario
	public String getId() {
		return this.id;
	}

	// fun��o que retorna os dados do usuario;
	public String toString() {
		return String.format(
				"id: %s \t nome: %s \t sobrenome: %s \t email: %s \t telefone: %s \t cpf: %s \t cep: %s \t admin: %s \t autenticado: %s \n",
				this.id, this.nome, this.sobrenome, this.email, this.telefone, this.cpf, this.cep, this.admin,
				this.autenticado);
	}
}
