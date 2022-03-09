import java.util.GregorianCalendar;
// Classe CursoAoVivo - responsável pela criação de cursos ao vivo (online);

public class CursoAoVivo extends Curso {
	
	
	private static GregorianCalendar dataComeco = new GregorianCalendar();
	private static GregorianCalendar dataEncerramento = new GregorianCalendar();
	
	public CursoAoVivo(String nomeCurso, double preco, Usuario criador, GregorianCalendar dataComeco,
			GregorianCalendar dataEncerramento) {
		super(nomeCurso, preco, criador);
		this.dataComeco = dataComeco;
		this.dataEncerramento = dataEncerramento;
	}

	public static GregorianCalendar getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(GregorianCalendar dataComeco) {
		this.dataComeco = dataComeco;
	}

	public static GregorianCalendar getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(GregorianCalendar dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	
	
	
	
	


}
