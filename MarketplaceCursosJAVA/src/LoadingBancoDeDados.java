import java.util.ArrayList;
import java.util.GregorianCalendar;

import java.text.*;
import java.util.Date;

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
	private String[] cursosAdquiridos = {"Python", "Jardinagem com Galdir Reges", "Java" };

	private String[] nomeCurso = {"Python","Java","C","POO","Desenvolvimento Web","Jardinagem com Galdir Reges","Hackeando do basico ao avancado","Ingles","Espanhol","Portugues","Italiano","Frances","Arabe","Chines","Javascript","PHP","Ruby on Rails","HTML e CSS","Day Trade","Criptomoedas","Java"};
	private double[] preco = {57.90,68.90,75.50,100.65,200.54,2000.00,3250.80,250.50,125.00,80.00,200.50,300.40,100.00,500.60,790.43,220.50,900.25,13.99,370.67,400.00,650.30};
	private int[] diaIni = {01,02,03,04,05,06,07,8,9,10,11,12,13,14};
	private int[] mesIni = {01,02,03,04,05,06,7,8,9,10,11,12,1,2};
	private int[] anoIni = {2022,2022,2022,2022,2022,2022,2022,2022,2022,2022,2022,2022,2023,2023}; 
	private int[] horaIni = {11,7,17,15,6,18,19,23,14,21,8,10,13,11};
	private int[] minutoIni = {00,15,00,30,45,34,20,25,00,10,15,40,35,50};
	private int[] diaEnc = {01,02,03,04,05,06,07,8,9,8,7,6,5,4};
	private int[] mesEnc = {2,4,6,8,10,12,1,3,5,7,9,11,12,12};
	private int[] anoEnc = {2022,2022,2022,2022,2022,2022,2023,2023,2023,2023,2023,2023,2023,2023};
	private int[] horaEnc = {12,9,19,17,8,20,22,0,15,23,10,11,15,12};
	private int[] minutoEnc = {00,00,20,30,15,25,30,35,40,45,35,25,10,50};
	private int[] vagas = {50,60,45,35,40,32,25};


	
GregorianCalendar comecoCurso8 = new GregorianCalendar();
GregorianCalendar comecoCurso9 = new GregorianCalendar();
GregorianCalendar comecoCurso10 = new GregorianCalendar();
GregorianCalendar comecoCurso11 = new GregorianCalendar();
GregorianCalendar comecoCurso12 = new GregorianCalendar();
GregorianCalendar comecoCurso13 = new GregorianCalendar();
GregorianCalendar comecoCurso14= new GregorianCalendar();
GregorianCalendar comecoCurso15 = new GregorianCalendar();
GregorianCalendar comecoCurso16 = new GregorianCalendar();
GregorianCalendar comecoCurso17 = new GregorianCalendar();
GregorianCalendar comecoCurso18 = new GregorianCalendar();
GregorianCalendar comecoCurso19 = new GregorianCalendar();
GregorianCalendar comecoCurso20 = new GregorianCalendar();
GregorianCalendar comecoCurso21= new GregorianCalendar();

GregorianCalendar[] datasIniciais = {comecoCurso8,comecoCurso9,comecoCurso10,comecoCurso11,comecoCurso12,comecoCurso13,comecoCurso14,comecoCurso15,comecoCurso16,comecoCurso17,comecoCurso18,comecoCurso19,comecoCurso20,comecoCurso21};
GregorianCalendar FinalCurso8 = new  GregorianCalendar();
GregorianCalendar FinalCurso9 = new  GregorianCalendar();
GregorianCalendar FinalCurso10 = new  GregorianCalendar();
GregorianCalendar FinalCurso11 = new  GregorianCalendar();
GregorianCalendar FinalCurso12 = new  GregorianCalendar();
GregorianCalendar FinalCurso13 = new  GregorianCalendar();
GregorianCalendar FinalCurso14 = new  GregorianCalendar();
GregorianCalendar FinalCurso15 = new  GregorianCalendar();
GregorianCalendar FinalCurso16 = new  GregorianCalendar();
GregorianCalendar FinalCurso17 = new  GregorianCalendar();
GregorianCalendar FinalCurso18 = new  GregorianCalendar();
GregorianCalendar FinalCurso19 = new  GregorianCalendar();
GregorianCalendar FinalCurso20 = new  GregorianCalendar();
GregorianCalendar FinalCurso21 = new  GregorianCalendar();
GregorianCalendar [] datasFinais = {FinalCurso8, FinalCurso9, FinalCurso10, FinalCurso11, FinalCurso12, FinalCurso13, FinalCurso14,FinalCurso15, FinalCurso16, FinalCurso17, FinalCurso18, FinalCurso19, FinalCurso20, FinalCurso21};
SimpleDateFormat  formatadorDeData = new SimpleDateFormat("dd-MM-yyyy HH:mm");



	// função que irá fazer o carregamento do banco e armazenar os dados e retornar true caso seja carregado;
	public boolean carregar(){
		
			
		
		for(int j=0; j<14;j++) {
					try {
						datasIniciais[j].setTime(formatadorDeData.parse(String.format("%d-%d-%d %d:%d",diaIni[j],mesIni[j],anoIni[j],horaIni[j],minutoIni[j])));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		for(int j=0; j<14;j++) {
			try {
				datasFinais[j].setTime(formatadorDeData.parse(String.format("%d-%d-%d %d:%d",diaEnc[j],mesEnc[j],anoEnc[j],horaEnc[j],minutoEnc[j])));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		
		
		
		
		
		// armazena usuario no banco de dados
		for(int i = 0; i < 3; i++) {
			Usuario usuario = new Usuario(nomes[i], sobrenomes[i], emails[i], senhas[i], telefones[i], cpfs[i], ceps[i], false, false, cursosAdquiridos[i]);
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
			CursoAoVivo curso = new CursoAoVivo(nomeCurso[k],preco[k], usuario[k], datasIniciais[k-7],datasFinais[k-7]);	
			BancoDeDados.armazenarCurso(curso);
		}


		//CRIANDO 7 CURSOS COM LIMITE DE VAGAS

		for(int l = 14; l < 21; l++){
			CursoVagas curso = new CursoVagas(nomeCurso[l], preco[l], usuario[l], datasIniciais[l-7],datasFinais[l-7],vagas[l-14]);
			BancoDeDados.armazenarCurso(curso);

		}
        
		// armazena um usuário administrador
		Usuario administrador = new Usuario("Root", "Admin", "admin@email.com", "root123", "99999999", "12345678900",
				"44444444", true, false, "");
		BancoDeDados.armazenarUsuario(administrador);

		this.carregado = true;

		return carregado;
	}





}