
public class CursoAoVivo extends Curso{
	
	private int vagas;
	
	public CursoAoVivo(String nomeCurso, String codigo, double preco, int diaIni, int mesIni, int anoIni, int horaIni, int minutoIni, int diaEnc,
			int mesEnc, int anoEnc, int horaEnc, int minutoEnc, String usuarioId, int vagas) {
		super();
		
		this.vagas = vagas;
		// TODO Auto-generated constructor stub
	}

	public CursoAoVivo(String nomeCurso, String codigo, Double preco, int vagas,
			int diaIni, int mesIni, int anoIni, int horaIni, int minutoIni, int diaEnc, int mesEnc, int anoEnc,
			int horaEnc, int minutoEnc, String id) {
		this.nomeCurso = nomeCurso;
		this.codigo = codigo;
		this.preco = preco;
		this.vagas = vagas;
		this.diaIni = diaIni;
		this.mesIni = mesIni;
		this.anoIni = anoIni;
		this.horaIni = horaIni;
		this.minutoIni = minutoIni;
		this.diaEnc = diaEnc;
		this.mesEnc = mesEnc;
		this.anoEnc = anoEnc;
		this.horaEnc = horaEnc;
		this.minutoEnc = minutoEnc;
		this.usuarioId = usuarioId;
		
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		if (vagas != 0) {
			this.vagas = vagas;
			vagas--;
		}
	}
}
