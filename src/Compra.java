// Classe compra - responsável pela realização de uma compra

import java.util.Random;


public class Compra {
	private Curso curso;
	private Usuario comprador;
	private String codigoCompra;
	
	public Compra(Curso curso, Usuario comprador) {
		this.curso = curso;
		this.comprador = comprador;
		this.codigoCompra = Long.toString(new Random().nextLong(0, 99999999)); // cria um código de números aleatórios
	}

	// retorna o curso comprado
	public Curso getCurso() {
		return curso;
	}
	
	// retornar o comprador
	public Usuario getComprador() {
		return comprador;
	}
	
	// retorna o código de compra
	public String getCodigo() {
		return codigoCompra;
	}

	@Override
	public String toString() {
		return String.format("Curso adquirido: \n %s Codigo de compra: %s \n %s \n Usuario Comprador: \n Nome:%s\t Id:%s\t E-mail:%s \n",curso, this.codigoCompra,comprador.getNome(),comprador.getId(),comprador.getEmail());
				//"Codigo da compra : "+id+"\nCurso : " +curso+"\ncomprador : "+ comprador + " \ncodigo = " + codigo + "\n";
	}

	
	
	
	
	
	
}
