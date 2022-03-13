// Classe CursoAoVivo - respons�vel pela cria��o de cursos ao vivo (online);
//Importa��o da classe Gregorian Calendar para usar o calend�rio
import java.util.GregorianCalendar;
public class CursoAoVivo extends Curso {
	
	
	private GregorianCalendar dataComeco = new GregorianCalendar();
	private GregorianCalendar dataEncerramento = new GregorianCalendar();
	
	public CursoAoVivo(String nomeCurso, double preco, Usuario criador, GregorianCalendar dataComeco,
			GregorianCalendar dataEncerramento) {
		super(nomeCurso, preco, criador);
		this.dataComeco = dataComeco;
		this.dataEncerramento = dataEncerramento;
	}

	public GregorianCalendar getDataComeco() {
		return dataComeco;
	}

	public void setDataComeco(GregorianCalendar dataComeco) {
		this.dataComeco = dataComeco;
	}

	public GregorianCalendar getDataEncerramento() {
		return dataEncerramento;
	}

	public void setDataEncerramento(GregorianCalendar dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	
	
	
	
	


}
