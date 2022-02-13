
public class Curso {

	private String nomeCurso;
	private String codigo;
	private double preco;
	private int vagas;
	private boolean cursoGravado;
	private boolean cursoAoVivo;
	private boolean cursoIndividual;
	private String usuarioId;
	private int diaIni, mesIni, anoIni, horaIni, minutoIni;
	private int diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc;

	// construtor para curso gravado

	public Curso(String nomeCurso, String codigo, double preco, boolean cursoGravado,
			boolean cursoAoVivo, boolean cursoIndividual, String usuarioId) {

		this.nomeCurso = nomeCurso;
		this.codigo = codigo;
		this.preco = preco;
		this.cursoGravado = cursoGravado;
		this.cursoAoVivo = cursoAoVivo;
		this.cursoIndividual = cursoIndividual;
		this.usuarioId = usuarioId;

	}

	// construtor para curso ao vivo

	public Curso(String nomeCurso, String codigo, double preco, int vagas, boolean cursoGravado,
			boolean cursoAoVivo, boolean cursoIndividual, int diaIni, int mesIni, int anoIni, int horaIni,
			int minutoIni, int diaEnc, int mesEnc, int anoEnc, int horaEnc, int minutoEnc, String usuarioId) {
		super();
		this.nomeCurso = nomeCurso;
		this.codigo = codigo;
		this.preco = preco;
		this.vagas = vagas;
		this.cursoGravado = cursoGravado;
		this.cursoAoVivo = cursoAoVivo;
		this.cursoIndividual = cursoIndividual;
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

	// construtor para curso Individual

	public Curso(String nomeCurso, String codigo, double preco, boolean cursoGravado,
			boolean cursoAoVivo, boolean cursoIndividual, int diaIni, int mesIni, int anoIni, int horaIni,
			int minutoIni, int diaEnc, int mesEnc, int anoEnc, int horaEnc, int minutoEnc, String usuarioId) {
		super();
		this.nomeCurso = nomeCurso;
		this.codigo = codigo;
		this.preco = preco;
		this.cursoGravado = cursoGravado;
		this.cursoAoVivo = cursoAoVivo;
		this.cursoIndividual = cursoIndividual;
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

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		if (vagas != 0) {
			this.vagas = vagas;
			vagas--;
		}
	}

	public boolean isCursoGravado() {
		return cursoGravado;
	}

	public void setCursoGravado(boolean cursoGravado) {
		this.cursoGravado = cursoGravado;
	}

	public boolean isCursoAoVivo() {
		return cursoAoVivo;
	}

	public void setCursoAoVivo(boolean cursoAoVivo) {
		this.cursoAoVivo = cursoAoVivo;
	}

	public boolean isCursoIndividual() {
		return cursoIndividual;
	}

	public void setCursoIndividual(boolean cursoIndividual) {
		this.cursoIndividual = cursoIndividual;
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
