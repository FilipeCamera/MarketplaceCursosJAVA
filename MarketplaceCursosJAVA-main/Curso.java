
public class Curso {

	protected String nomeCurso;
	protected String codigo;
	protected double preco;
	protected String usuarioId;
	protected int diaIni, mesIni, anoIni, horaIni, minutoIni;
	protected int diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc;

	
	// construtor para curso Individual

	
	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		if (preco >= 0) {
			this.preco = preco;
		} else {
			throw new IllegalArgumentException("Preco negativo invalido");
		}
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getUsuarioId () {
		return usuarioId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String getDonoCurso() {
		String nome = null;
		for(Usuario donoCurso : BancoDeDados.lerArmazenamentoUsuarios()) {
			if(this.usuarioId == donoCurso.getId()) {
				nome = String.format("criador: %s", donoCurso.getNome());
			}
		}
		return nome;
	}

	public String toString() {
		return String.format("código: %s - titulo: %s - valor: R$ %s \t \n", this.codigo, this.nomeCurso, this.preco);
	}

}
