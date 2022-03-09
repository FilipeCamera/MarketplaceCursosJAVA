import java.util.UUID;

public class Compra {
	private String id = UUID.randomUUID().toString();
	private Curso curso;
	private Usuario comprador;
	private int codigo;
	
	public Compra(Curso curso, Usuario comprador, int codigo) {
		this.curso = curso;
		this.comprador = comprador;
		this.codigo = codigo;
	}
}
