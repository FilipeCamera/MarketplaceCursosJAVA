import java.util.ArrayList;

// Classe LoadingBancoDeDados - responsável pelo carregamento inicial da plataforma criando alguns usuários e produtos

public class LoadingBancoDeDados {
	private String[] nomes = {"Alan", "Maria", "Francisco"};
	private String[] sobrenomes = {"Souza", "Eduarda", "Neto"};
	private String[] senhas = {"alan123", "duda123", "neto123"};
	private String[] emails = {"alan@email.com", "maria@email.com", "neto@email.com"};
	private String[] cpfs = {"12345678911", "11987654321", "78912345644"};
	private String[] ceps = {"12345000", "00012345", "20200345"};
	private String[] telefones = {"956564343", "938384545", "956553434"};
	private boolean carregado;

	private String[] nomeCurso = {"Python","Java","C","POO","Desenvolvimento Web","Jardinagem com Galdir Reges","Hackeando do basico ao avancado","Ingles","Espanhol","Portugues","Italiano","Frances","Arabe","Chines","Javascript","PHP","Ruby on Rails","HTML e CSS","Day Trade","Criptomoedas","Java"};
	private double[] preco = {57.90,68.90,75.50,100.65,200.54,2000.00,3250.80,250.50,125.00,80.00,200.50,300.40,100.00,500.60,790.43,220.50,900.25,13.99,370.67,400.00,650.30};
	private int[] diaIni = {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
	private int[] mesIni = {1,2,3,4,5,6,7,8,9,10,11,12,1,2};
	private int[] anoIni = {2022,2022,2022,2022,2022,2022,2022,2022,2022,2022,2022,2022,2023,2023}; 
	private int[] horaIni = {11,7,17,15,6,18,19,23,14,21,8,10,13,11};
	private int[] minutoIni = {0,15,0,30,45,34,20,25,0,10,15,40,35,50};
	private int[] diaEnc = {1,2,3,4,5,6,7,8,9,8,7,6,5,4};
	private int[] mesEnc = {2,4,6,8,10,12,1,3,5,7,9,11,12,12};
	private int[] anoEnc = {2022,2022,2022,2022,2022,2022,2023,2023,2023,2023,2023,2023,2023,2023};
	private int[] horaEnc = {12,9,19,17,8,20,22,0,15,23,10,11,15,12};
	private int[] minutoEnc = {0,0,20,30,15,25,30,35,40,45,35,25,10,50};
	private int[] vagas = {50,60,45,35,40,32,25};


	// função que irá fazer o carregamento do banco e armazenar os dados e retornar true caso seja carregado;
	public boolean carregar() {

		// armazena usuario no banco de dados
		for(int i = 0; i < 3; i++) {
			Usuario usuario = new Usuario(nomes[i], sobrenomes[i], emails[i], senhas[i], telefones[i], cpfs[i], ceps[i], false, false);
			BancoDeDados.armazenarUsuario(usuario);
		}
		Usuario[] usuario = {BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2),
				BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2),
				BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2),
				BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2),
				BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2),
				BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2),
				BancoDeDados.lerArmazenamentoUsuarios().get(0),
				BancoDeDados.lerArmazenamentoUsuarios().get(1),
				BancoDeDados.lerArmazenamentoUsuarios().get(2)};




		//CRIANDO 7 CURSOS GRAVADOS

		for(int j = 0; j < 7; j++){
			Curso curso = new Curso(nomeCurso[j],preco[j], usuario[j]);
			BancoDeDados.armazenarCurso(curso);
		}

		//CRIANDO 7 CURSOS AO VIVO

		for(int k = 7; k < 14; k++){
			CursoAoVivo curso = new CursoAoVivo(nomeCurso[k],preco[k], diaIni[k-7], mesIni[k-7], anoIni[k-7], horaIni[k-7], minutoIni[k-7], diaEnc[k-7],
					mesEnc[k-7], anoEnc[k-7], horaEnc[k-7], minutoEnc[k-7], usuario[k]);	
			BancoDeDados.armazenarCurso(curso);
		}


		//CRIANDO 7 CURSOS COM LIMITE DE VAGAS

		for(int l = 14; l < 21; l++){
			CursoVagas curso = new CursoVagas(nomeCurso[l], preco[l], diaIni[l-7], mesIni[l-7], anoIni[l-7], horaIni[l-7], minutoIni[l-7], diaEnc[l-7],
					mesEnc[l-7], anoEnc[l-7], horaEnc[l-7], minutoEnc[l-7], usuario[l], vagas[l-14]);
			BancoDeDados.armazenarCurso(curso);

		}

		// armazena um usuário administrador
		Usuario administrador = new Usuario("Root", "Admin", "admin@email.com", "root123", "99999999", "12345678900",
				"44444444", true, false);
		BancoDeDados.armazenarUsuario(administrador);

		this.carregado = true;

		return carregado;
	}





}