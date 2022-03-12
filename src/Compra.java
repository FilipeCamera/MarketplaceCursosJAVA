import java.util.Random;
import java.util.UUID;

public class Compra {
	private String id = UUID.randomUUID().toString();
	private Curso curso;
	private Usuario comprador;
	private String codigoCompra;
	
	public Compra(Curso curso, Usuario comprador) {
		this.curso = curso;
		this.comprador = comprador;
		this.codigoCompra = Long.toString(new Random().nextLong(0, 99999999));
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
	public String getCodigo() {
		return codigoCompra;
	}

	@Override
	public String toString() {
		return String.format("Curso adquirido: \n ID: %s \n %s \n Usuario Comprador: \n Nome:%s\t Id:%s\t E-mail:%s \n",id,curso,comprador.getNome(),comprador.getId(),comprador.getEmail());
				//"Codigo da compra : "+id+"\nCurso : " +curso+"\ncomprador : "+ comprador + " \ncodigo = " + codigo + "\n";
	}

	
	
	
	
	
	
}
