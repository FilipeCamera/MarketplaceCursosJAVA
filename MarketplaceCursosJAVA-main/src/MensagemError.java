// Classe MensagemError - respons�vel pela exceções dentro da aplicação

public class MensagemError extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6168670211255087397L;

	public MensagemError(String message) {
		super(message);
	}
	
	public MensagemError(String message, Throwable cause) {
		super(message, cause);
	}
}
