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

	public String getId() {
		return id;
	}
	public Curso getCurso() {
		return curso;
	}
	public Usuario getComprador() {
		return comprador;
	}
	public int getCodigo() {
		return codigo;
	}

	@Override
	public String toString() {
		return String.format("Curso adquirido:%sID:%s\nUsuario Comprador: Nome:%s\t Id:%s\t E-mail:%s\n",curso,id,comprador.getNome(),comprador.getId(),comprador.getEmail());
				//"Codigo da compra : "+id+"\nCurso : " +curso+"\ncomprador : "+ comprador + " \ncodigo = " + codigo + "\n";
	}

	
	
	
	
	
	
}
