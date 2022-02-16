import java.util.ArrayList;
import java.util.Scanner;

public class TelaCursos {

	public void listarCursos(Scanner entrada) {
		if(BancoDeDados.lerArmazenamentoCursos().size()!=0) {
			int quantidadeListados=10;
			int expandirLista, detalharCurso;
			String codigoCurso=null;
			boolean mostrarCursos= true;
			boolean cursoEncontrado;

			while(mostrarCursos) {

				System.out.print("=====\t Cursos disponiveis \t=====\n");

				if (BancoDeDados.lerArmazenamentoCursos().size()>=quantidadeListados) {
					for(int i=0;i<quantidadeListados;i++) {
						System.out.println(BancoDeDados.lerArmazenamentoCursos().get(i));
					}

				}else{
					for(int i=0;i<BancoDeDados.lerArmazenamentoCursos().size();i++) {
						System.out.println(BancoDeDados.lerArmazenamentoCursos().get(i));
						quantidadeListados=BancoDeDados.lerArmazenamentoCursos().size();//informacao usada no proximo for
					}
				}

				System.out.println("Deseja detalhar algum curso?1-Sim, 2-Nao");

				detalharCurso=entrada.nextInt();
				entrada.nextLine();//limpando o buffer do teclado

				while(detalharCurso==1) {

					System.out.println("Infome codigo do curso:");
					codigoCurso=entrada.nextLine();

					cursoEncontrado=false;//para a variavel voltar a ser falsa apos encontrar algum curso
					for(int i=0;i<quantidadeListados;i++) {

						if(BancoDeDados.lerArmazenamentoCursos().get(i).getCodigo().equals(codigoCurso)) {
							cursoEncontrado=true;
							detalharCurso=2;//encerra o while

							if(BancoDeDados.lerArmazenamentoCursos().get(i) instanceof CursoGravado) {
								System.out.println(BancoDeDados.lerArmazenamentoCursos().get(i));
							}
							else {
								CursoDataHora cursoDataHora = (CursoDataHora) BancoDeDados.lerArmazenamentoCursos().get(i);
								System.out.printf(cursoDataHora+"Inicia dia:%d/%d/%d as %d:%d \n",cursoDataHora.getDiaIni(),cursoDataHora.getMesIni(),cursoDataHora.getAnoIni(),cursoDataHora.getHoraIni(),cursoDataHora.getMinutoIni());
							}

						}	
					}

					if(cursoEncontrado==false){
						System.out.println("Curso não encontrado!Ainda deseja detalhar?1-Sim, 2-Nao");
						detalharCurso=entrada.nextInt();
						entrada.nextLine();//limpando o buffer do teclado
					}

				}//fim segundo while 



				System.out.println("Listar mais 10 cursos? 1-Sim, 2-Nao 3-encerrar");
				expandirLista=entrada.nextInt();
				if(expandirLista==1){
					quantidadeListados+=10;//permite mostrar mais 10 cursos
				}
				if(detalharCurso==3 || expandirLista==3) {
					mostrarCursos=false;//encerra a listagem de cursos
				}
			}

		}else {
			System.out.println("Nao ha cursos cadastrados");
		}
	}
	
	public void criarCurso(Usuario usuario, Scanner entrada) {
		if (usuario != null && usuario.getAutenticado() == true) {
			System.out.print("Informe nome do curso:");
			String nomeCurso = entrada.nextLine();
			System.out.print("Informe tipo do curso (1-Gravado,2-Ao Vivo 3-Individual):");
			int tipoCurso = entrada.nextInt();
			entrada.nextLine();
			System.out.print("Informe valor do curso:");
			Double preco = entrada.nextDouble();

			if (tipoCurso != 1) {
				System.out.println("Informe dia que inicia o curso:");
				int diaIni = entrada.nextInt();
				System.out.println("Informe mes que inicia o curso:");
				int mesIni = entrada.nextInt();
				System.out.println("Informe ano que inicia o curso:");
				int anoIni = entrada.nextInt();
				System.out.println("Informe hora que inicia o curso:");
				int horaIni = entrada.nextInt();
				System.out.println("Informe minuto que inicia o curso:");
				int minutoIni = entrada.nextInt();
				System.out.println("Informe dia que encerra o curso:");
				int diaEnc = entrada.nextInt();
				System.out.println("Informe mes que encerra o curso:");
				int mesEnc = entrada.nextInt();
				System.out.println("Informe ano que encerra o curso:");
				int anoEnc = entrada.nextInt();
				System.out.println("Informe hora que encerra o curso:");
				int horaEnc = entrada.nextInt();
				System.out.println("Informe minuto que encerra o curso:");
				int minutoEnc = entrada.nextInt();

				if (tipoCurso == 2) {
					System.out.println("Informe numero de vagas:");
					int vagas = entrada.nextInt();
					Curso curso = new CursoAoVivo(nomeCurso, preco, diaIni, mesIni, anoIni, horaIni, minutoIni, diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc,
							usuario, vagas);
					BancoDeDados.armazenarCurso(curso);
				}

				if (tipoCurso == 3) {
					Curso curso = new CursoIndividual(nomeCurso, preco, diaIni, mesIni, anoIni, horaIni,
							minutoIni, diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc, usuario);
					BancoDeDados.armazenarCurso(curso);
				}
			} else {
				Curso curso = new CursoGravado(nomeCurso, preco, usuario);
				BancoDeDados.armazenarCurso(curso);
			}

		} else {
			System.out.println("Para criar um curso o usuário precisa tá autenticado!");
		}
	}
	
	public void editarCurso(Usuario usuario, Scanner entrada, ArrayList<Curso> cursos) {
		String escolhaCursoEditar;
		if(usuario == null || usuario.getAutenticado() != true) {
			System.out.println("Usuário precisa está autenticado para editar algum curso");
		} else {
			for(Curso cursoEditar : cursos) {
				if(cursoEditar.getCriador().equals(usuario)) {
					System.out.println("=====\t Seus cursos \t=====");
					System.out.println(cursoEditar);
				}
			}
			System.out.print("Escolha o curso que quer editar (código): ");
			escolhaCursoEditar = entrada.nextLine();

			for(Curso cursoEditar : cursos) {
				if(cursoEditar.getCodigo().equals(escolhaCursoEditar) && cursoEditar.getCriador().equals(usuario)) {
					System.out.print("Informe nome do curso:");
					cursoEditar.setNomeCurso(entrada.nextLine());
					entrada.nextLine();
					System.out.print("Informe valor do curso:");
					cursoEditar.setPreco(entrada.nextDouble());

					if (cursoEditar instanceof CursoAoVivo) {
						CursoAoVivo cursoAoVivoEditar = (CursoAoVivo) cursoEditar;
						System.out.println("Informe dia que inicia o curso:");
						cursoAoVivoEditar.setDiaIni(entrada.nextInt());
						System.out.println("Informe mes que inicia o curso:");
						cursoAoVivoEditar.setMesIni(entrada.nextInt());
						System.out.println("Informe ano que inicia o curso:");
						cursoAoVivoEditar.setAnoIni(entrada.nextInt());
						System.out.println("Informe hora que inicia o curso:");
						cursoAoVivoEditar.setHoraIni(entrada.nextInt());
						System.out.println("Informe minuto que inicia o curso:");
						cursoAoVivoEditar.setMinutoIni(entrada.nextInt());
						System.out.println("Informe dia que encerra o curso:");
						cursoAoVivoEditar.setDiaEnc(entrada.nextInt());
						System.out.println("Informe mes que encerra o curso:");
						cursoAoVivoEditar.setMesEnc(entrada.nextInt());
						System.out.println("Informe ano que encerra o curso:");
						cursoAoVivoEditar.setAnoEnc(entrada.nextInt());
						System.out.println("Informe hora que encerra o curso:");
						cursoAoVivoEditar.setHoraEnc(entrada.nextInt());
						System.out.println("Informe minuto que encerra o curso:");
						cursoAoVivoEditar.setMinutoEnc(entrada.nextInt());
						System.out.println("Informe numero de vagas:");
						cursoAoVivoEditar.setVagas(entrada.nextInt());
						
					}
					if (cursoEditar instanceof CursoIndividual) {
						CursoIndividual cursoIndividualEditar = (CursoIndividual) cursoEditar;
						System.out.println("Informe dia que inicia o curso:");
						cursoIndividualEditar.setDiaIni(entrada.nextInt());
						System.out.println("Informe mes que inicia o curso:");
						cursoIndividualEditar.setMesIni(entrada.nextInt());
						System.out.println("Informe ano que inicia o curso:");
						cursoIndividualEditar.setAnoIni(entrada.nextInt());
						System.out.println("Informe hora que inicia o curso:");
						cursoIndividualEditar.setHoraIni(entrada.nextInt());
						System.out.println("Informe minuto que inicia o curso:");
						cursoIndividualEditar.setMinutoIni(entrada.nextInt());
						System.out.println("Informe dia que encerra o curso:");
						cursoIndividualEditar.setDiaEnc(entrada.nextInt());
						System.out.println("Informe mes que encerra o curso:");
						cursoIndividualEditar.setMesEnc(entrada.nextInt());
						System.out.println("Informe ano que encerra o curso:");
						cursoIndividualEditar.setAnoEnc(entrada.nextInt());
						System.out.println("Informe hora que encerra o curso:");
						cursoIndividualEditar.setHoraEnc(entrada.nextInt());
						System.out.println("Informe minuto que encerra o curso:");
						cursoIndividualEditar.setMinutoEnc(entrada.nextInt());
						
					}

					System.out.println("Alteração feita com sucesso!");
					break;
				} else {
					System.out.println("Tivemos um problema, por favor tente novamente mais tarde.");
					break;
				}
			}
		}
	}
	
	public void excluirCurso(Usuario usuario, Scanner entrada, ArrayList<Curso> cursos) {
		String escolhaCursoDeletar;
		if(usuario == null || usuario.getAutenticado() != true) {
			System.out.println("Usuário precisa está autenticado para excluir algum curso");
		} else {
			for(Curso cursoDeletar : cursos) {
				if(cursoDeletar.getCriador().equals(usuario)) {
					System.out.println("=====\t Seus cursos \t=====");
					System.out.println(cursoDeletar);
				}
			}
			System.out.print("Escolha o curso que quer editar (código): ");
			escolhaCursoDeletar = entrada.nextLine();

			for(Curso cursoDeletar : cursos) {
				if(cursoDeletar.getCodigo().equals(escolhaCursoDeletar) && cursoDeletar.getCriador().equals(usuario)) {

					cursos.remove(cursoDeletar);


					System.out.println("Curso excluido com sucesso!");
					break;
				} else {
					System.out.println("Tivemos um problema, por favor tente novamente mais tarde.");
					break;
				}
			}
		}
	}

}
