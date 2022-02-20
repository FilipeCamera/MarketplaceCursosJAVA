
// Classe CursoAoVivo - responsável pela criação de cursos ao vivo (online);

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
	
	// função que retorna o dia que inicia
	public int getDiaIni() {
		return diaIni;
	}
	
	// funç]ao que seta o dia que inicia
	public void setDiaIni(int diaIni) {
		this.diaIni = diaIni;
	}
	
	// função que retorna o mês que inicia
	public int getMesIni() {
		return mesIni;
	}

	// funç]ao que seta o mês que inicia
	public void setMesIni(int mesIni) {
		this.mesIni = mesIni;
	}

	// função que retorna o ano que inicia
	public int getAnoIni() {
		return anoIni;
	}

	// função que seta o ano que inicia
	public void setAnoIni(int anoIni) {
		this.anoIni = anoIni;
	}

	// função que retorna a hora que incia
	public int getHoraIni() {
		return horaIni;
	}
	
	// função que seta a hora que inicia
	public void setHoraIni(int horaIni) {
		this.horaIni = horaIni;
	}
	

	// função que retorna o minuto que inicia
	public int getMinutoIni() {
		return minutoIni;
	}

	// função que seta o minuto que inicia
	public void setMinutoIni(int minutoIni) {
		this.minutoIni = minutoIni;
	}

	// função que retorna o dia que encerra
	public int getDiaEnc() {
		return diaEnc;
	}

	// função que seta o dia que encerra
	public void setDiaEnc(int diaEnc) {
		this.diaEnc = diaEnc;
	}

	// função que retorna o mes que encerra
	public int getMesEnc() {
		return mesEnc;
	}

	// função que seta o mes que encerra
	public void setMesEnc(int mesEnc) {
		this.mesEnc = mesEnc;
	}

	// função que retorna o ano que encerra
	public int getAnoEnc() {
		return anoEnc;
	}

	// função que seta o ano que encerra
	public void setAnoEnc(int anoEnc) {
		this.anoEnc = anoEnc;
	}

	// função que retorna a hora que encerra
	public int getHoraEnc() {
		return horaEnc;
	}

	// função que seta a hora que encerra
	public void setHoraEnc(int horaEnc) {
		this.horaEnc = horaEnc;
	}

	// função que retorna o minuto que encerra
	public int getMinutoEnc() {
		return minutoEnc;
	}

	// função que seta o minuto que encerra
	public void setMinutoEnc(int minutoEnc) {
		this.minutoEnc = minutoEnc;
	}
	


}
