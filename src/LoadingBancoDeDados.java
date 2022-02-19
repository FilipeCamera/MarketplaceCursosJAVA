import java.util.ArrayList;

public class LoadingBancoDeDados {
	private String[] nomes = {"Alan", "Maria", "Francisco"};
	private String[] sobrenomes = {"Souza", "Eduarda", "Neto"};
	private String[] senhas = {"alan123", "duda123", "neto123"};
	private String[] emails = {"alan@email.com", "maria@email.com", "neto@email.com"};
	private String[] cpfs = {"12345678911", "11987654321", "78912345644"};
	private String[] ceps = {"12345000", "00012345", "20200345"};
	private String[] telefones = {"956564343", "938384545", "956553434"};
	private boolean carregado;
	public boolean carregar() {
		
		for(int i = 0; i < 3; i++) {
			Usuario usuario = new Usuario(nomes[i], sobrenomes[i], emails[i], senhas[i], telefones[i], cpfs[i], ceps[i], false, false);
			BancoDeDados.armazenarUsuario(usuario);
			this.carregado = true;
		}
		return carregado;
	}
}
