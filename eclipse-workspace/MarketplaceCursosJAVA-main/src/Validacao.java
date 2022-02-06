// Classe de validação

public class Validacao extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6168670211255087397L;

	public Validacao(String message) {
		super(message);
	}
	
	public Validacao(String message, Throwable cause) {
		super(message, cause);
	}
}
