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
	private String tipo;
	private ArrayList<Curso> cursosMatriculados;


	public Usuario(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep, String tipo, boolean autenticado) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.autenticado = autenticado;
		this.tipo = tipo;
	}

	public String getEmail() {
		return this.email;
	}

	public String getSenha() {
		return this.senha;
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public boolean getAutenticado() {
		return this.autenticado;
	}

	public void setCursoMatriculado(Curso curso) {
		this.cursosMatriculados.add(curso);
	}

	// Função que retorna os dados do usuário;
	public String toString() {
		return String.format("id: %s \t nome: %s \t sobrenome: %s \t email: %s \t telefone: %s \t cpf: %s \t cep: %s \t tipo: %s \t autenticado: %s \n", this.id, this.nome, this.sobrenome, this.email, this.telefone, this.cpf, this.cep, this.tipo, this.autenticado);
	}
}
