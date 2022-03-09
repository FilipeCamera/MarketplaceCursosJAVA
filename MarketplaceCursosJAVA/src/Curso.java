import java.util.UUID;

// Classe Curso - responsável pela criação de curso ou (gravado)

public class Curso {

	private  String nomeCurso;
	private String codigo = UUID.randomUUID().toString(); // cria o código do curso
	private double preco;
	private Usuario criador;
	
	public Curso(String nomeCurso, double preco, Usuario criador) {
		this.nomeCurso = nomeCurso;
		this.preco = preco;
		this.criador = criador;
	}

	// função que retorna o preço do curso
	public double getPreco() {
		return preco;
	}

	// função que seta o preço do curso com excessão caso seja < 0
	public void setPreco(double preco) {
		if (preco >= 0) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException("Preco negativo invalido");
		}
	}
	
	// função que irá setar o criador do curso
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}
	
	// função que retorna o nome do curso
	public String getNomeCurso() {
		return nomeCurso;
	}

	// função que irá setar o nome do curso
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	// função que ira retornar o criador do curso
	public Usuario getCriador () {
		return criador;
	}

	// função que retorna o código do curso
	public String getCodigo() {
		return codigo;
	}
	
	// função que retorna algumas informações do curso
	public String toString() {
		return String.format("código: %s - titulo: %s - valor: R$ %s \t \n", this.codigo, this.nomeCurso, this.preco);
	}

}