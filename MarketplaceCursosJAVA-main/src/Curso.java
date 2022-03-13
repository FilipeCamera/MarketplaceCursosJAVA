import java.util.Random;

// Classe Curso - respons�vel pela cria��o de curso ou (gravado)

public class Curso {

	private String nomeCurso;
	private String codigo; // cria o c�digo do curso
	private double preco;
	private Usuario criador;
	
	public Curso(String nomeCurso, double preco, Usuario criador) {
		this.nomeCurso = nomeCurso;
		this.preco = preco;
		this.criador = criador;
		//Gera um codigo aleatorio com numeros entre 0 e 99999999
		this.codigo = Long.toString(new Random().nextLong(0, 999999999));
	}

	// fun��o que retorna o pre�o do curso
	public double getPreco() {
		return preco;
	}

	// fun��o que seta o pre�o do curso com exce��o caso seja < 0
	public void setPreco(double preco) {
		if (preco >= 0) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException("Preco negativo invalido");
		}
	}
	
	// fun��o que ir� setar o criador do curso
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}
	
	// fun��o que retorna o nome do curso
	public String getNomeCurso() {
		return nomeCurso;
	}

	// fun��o que ir� setar o nome do curso
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	// fun��o que ira retornar o criador do curso
	public Usuario getCriador () {
		return criador;
	}

	// fun��o que retorna o c�digo do curso
	public String getCodigo() {
		return codigo;
	}
	
	// fun��o que retorna algumas informa��es do curso
	public String toString() {
		return String.format("codigo: %s - titulo: %s - valor: R$ %s \t \n", this.codigo, this.nomeCurso, this.preco);
	}

}