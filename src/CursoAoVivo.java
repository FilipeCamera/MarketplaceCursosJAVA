
public class CursoAoVivo extends Curso {
	
	private int diaIni, mesIni, anoIni, horaIni, minutoIni;
	private int diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc;
	
	public CursoAoVivo(String nomeCurso, double preco, int diaIni, int mesIni, int anoIni, int horaIni, int minutoIni, int diaEnc,
			int mesEnc, int anoEnc, int horaEnc, int minutoEnc, Usuario criador) {
		super(nomeCurso, preco, criador);
		// TODO Auto-generated constructor stub
		
		this.diaIni = diaIni;
		this.diaEnc = diaEnc;
		this.mesIni = mesIni;
		this.mesEnc = mesEnc;
		this.anoIni = anoIni;
		this.anoEnc = anoEnc;
		this.horaIni = horaIni;
		this.horaEnc = horaEnc;
		this.minutoIni = minutoIni;
		this.minutoEnc = minutoEnc;
	}
	
	public int getDiaIni() {
		return diaIni;
	}

	public void setDiaIni(int diaIni) {
		this.diaIni = diaIni;
	}

	public int getMesIni() {
		return mesIni;
	}

	public void setMesIni(int mesIni) {
		this.mesIni = mesIni;
	}

	public int getAnoIni() {
		return anoIni;
	}

	public void setAnoIni(int anoIni) {
		this.anoIni = anoIni;
	}

	public int getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(int horaIni) {
		this.horaIni = horaIni;
	}

	public int getMinutoIni() {
		return minutoIni;
	}

	public void setMinutoIni(int minutoIni) {
		this.minutoIni = minutoIni;
	}

	public int getDiaEnc() {
		return diaEnc;
	}

	public void setDiaEnc(int diaEnc) {
		this.diaEnc = diaEnc;
	}

	public int getMesEnc() {
		return mesEnc;
	}

	public void setMesEnc(int mesEnc) {
		this.mesEnc = mesEnc;
	}

	public int getAnoEnc() {
		return anoEnc;
	}

	public void setAnoEnc(int anoEnc) {
		this.anoEnc = anoEnc;
	}

	public int getHoraEnc() {
		return horaEnc;
	}

	public void setHoraEnc(int horaEnc) {
		this.horaEnc = horaEnc;
	}

	public int getMinutoEnc() {
		return minutoEnc;
	}

	public void setMinutoEnc(int minutoEnc) {
		this.minutoEnc = minutoEnc;
	}

}
