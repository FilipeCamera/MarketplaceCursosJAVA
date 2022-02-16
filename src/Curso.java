import java.util.UUID;

public class Curso {

	private String nomeCurso;
	private String codigo = UUID.randomUUID().toString();;
	private double preco;
	private Usuario criador;
	
	public Curso(String nomeCurso, double preco, Usuario criador) {
		this.nomeCurso = nomeCurso;
		this.preco = preco;
		this.criador = criador;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco >= 0) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException("Preco negativo invalido");
		}
	}
	
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}
	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Usuario getCriador () {
		return criador;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public String getDonoCurso() {
		String nome = null;
		for(Usuario donoCurso : BancoDeDados.lerArmazenamentoUsuarios()) {
			if(this.criador == donoCurso) {
				nome = String.format("criador: %s", donoCurso.getNome());
			}
		}
		return nome;
	}

	public String toString() {
		return String.format("código: %s - titulo: %s - valor: R$ %s \t \n", this.codigo, this.nomeCurso, this.preco);
	}

}