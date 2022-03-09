import java.util.ArrayList;
import java.util.UUID;

// Classe Usuário

public class Usuario {
	private String id = UUID.randomUUID().toString(); // id de identificação do usuário
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private String telefone;
	private String cpf;
	private String cep;
	private boolean autenticado;
	private boolean admin;
	static ArrayList <String> cursosAdquiridos = new ArrayList(); 

	public Usuario(String nomes, String sobrenomes, String emails, String senhas, String telefones, String cpfs, String ceps, boolean b, boolean c, String cursosAdquiridos) {
	};

	public Usuario(String nome, String sobrenome, String email, String senha, String telefone, String cpf, String cep,
			boolean admin, boolean autenticado, ArrayList<String> cursosAdquiridos) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;
		this.cpf = cpf;
		this.cep = cep;
		this.autenticado = autenticado;
		this.admin = admin;
		this.cursosAdquiridos=cursosAdquiridos;
	}
	
	// função que retorna o nome
	public String getNome() {
		return this.nome;
	}

	// função que retorna o e-mail
	public String getEmail() {
		return this.email;
	}

	// função que retorna a senha
	public String getSenha() {
		return this.senha;
	}
	
	// função que retorna se o usuário é administrador ou n
	public boolean getAdmin() {
		return this.admin;
	}
	
	// função que seta se o usuário vai está autenticado ou não
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	// função que retorna se o usuário está autenticado
	public boolean getAutenticado() {
		return this.autenticado;
	}
	
	// função que retorna a quatidadde de curso criado pelo usuário
	public int getQuantCursoCriado() {
		int total = 0;
		for(Curso cursoCriado : BancoDeDados.lerArmazenamentoCursos()) {
			if(cursoCriado.getCriador().getId() == id) {
				total++;
			}
		}
		
		return total;
	}

	public static ArrayList<String> getCursosAdquiridos() {
		return cursosAdquiridos;
	}

	public void setCursosAdquiridos(ArrayList<String> cursosAdquiridos) {
		this.cursosAdquiridos = cursosAdquiridos;
	}

	// função que retorna o ID do usuário
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
