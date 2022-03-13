import java.util.GregorianCalendar;
// Classe CursoAoVivo - responsável pela criação de cursos ao vivo (online);

public class CursoAoVivo extends Curso {
	
	// variaveis data
	private GregorianCalendar dataComeco = new GregorianCalendar();
	private GregorianCalendar dataEncerramento = new GregorianCalendar();
	
	public CursoAoVivo(String nomeCurso, double preco, Usuario criador, GregorianCalendar dataComeco,
			GregorianCalendar dataEncerramento) {
		super(nomeCurso, preco, criador);
		this.dataComeco = dataComeco;
		this.dataEncerramento = dataEncerramento;
	}

	// funcao que retonar data de começo do curso
	public GregorianCalendar getDataComeco() {
		return dataComeco;
	}

	// funcao que cria uma data de começo do curso
	public void setDataComeco(GregorianCalendar dataComeco) {
		this.dataComeco = dataComeco;
	}

	// funcao retonar data que encerra o curso
	public GregorianCalendar getDataEncerramento() {
		return dataEncerramento;
	}

	// funcao que cria a data de encerramento do curso
	public void setDataEncerramento(GregorianCalendar dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	
	
	
	
	


}
