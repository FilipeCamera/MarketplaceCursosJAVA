
// Classe CursoVaga - responsável pela criação de curso com limite de usuários(vagas);

public class CursoVagas extends CursoAoVivo{

	private int vagas;

	public CursoVagas(String nomeCurso, double preco, int diaIni, int mesIni, int anoIni, int horaIni, int minutoIni, int diaEnc,
			int mesEnc, int anoEnc, int horaEnc, int minutoEnc, Usuario criador, int vagas) {
		super(nomeCurso, preco, diaIni, diaEnc, mesIni, mesEnc, anoIni, anoEnc, horaIni, horaEnc, minutoIni, minutoEnc, criador);

		this.vagas = vagas;
		// TODO Auto-generated constructor stub
	}

	// função que retorna a quantidade de vagas do curso
	public int getVagas() {
		return vagas;
	}

	// função que seta a quantidade de vagas do curso e pode retornar um erro caso o valor seja menor ou igual a 0
	public void setVagas(int vagas) throws MensagemError {
		if (vagas > 0) {
			this.vagas = vagas;

		} else {
			throw new MensagemError("A quantidade de vagas tem que ser maior que 0");
		}
	}
	
	
	

}
