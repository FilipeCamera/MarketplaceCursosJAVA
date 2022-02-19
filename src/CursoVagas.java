public class CursoVagas extends CursoAoVivo{

	private int vagas;

	public CursoVagas(String nomeCurso, double preco, int diaIni, int mesIni, int anoIni, int horaIni, int minutoIni, int diaEnc,
			int mesEnc, int anoEnc, int horaEnc, int minutoEnc, Usuario criador, int vagas) {
		super(nomeCurso, preco, diaIni, diaEnc, mesIni, mesEnc, anoIni, anoEnc, horaIni, horaEnc, minutoIni, minutoEnc, criador);

		this.vagas = vagas;
		// TODO Auto-generated constructor stub
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		if (vagas != 0) {
			this.vagas = vagas;

		}
	}
}
