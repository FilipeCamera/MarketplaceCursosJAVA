
public class Tipos_de_Curso extends Cursos{
	private boolean cursoAoVivo;
	private boolean curso_gravado;
	private boolean curso_individual;
	

	public Tipos_de_Curso(String nome_curso, int carga_h, int prazo, String tipo, float preco) {
		super(nome_curso, carga_h, prazo, preco);
		this.cursoAoVivo = cursoAoVivo;
		this.curso_gravado = curso_gravado;
		this.curso_individual=curso_individual;
		
	}
	
	
	
	public String toString(){
		
		return("Curso:" + super.nome_curso + "\n " + "Carga horaria" + super.carga_h + "\n"
				+ "Prazo:" + super.prazo + "\n" + "Preco: R$" + super.preco +  ".");
	}
}
