import java.util.ArrayList;
import java.util.Scanner;
import java.text.*;
import java.util.GregorianCalendar;

/* Classe responsável por mostrar a listagem de cursos, criação, edição e remoção de curso
 * além disso, também é responsável por detalhar e fazer a compra de algum curso
 *  */

public class TelaCursos {

	SimpleDateFormat formatadorDeData = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	
	// função de listar cursos - detalhar e comprar
	public void listarCursos(Scanner entrada, Usuario comprador, ArrayList<Curso> cursos) {
		if(cursos.size()!=0) {
			int quantidadeListados=10;
			int indiceInicial=0;
			int expandirLista, opcaoCurso, escolha;
			String codigoCurso=null;
			boolean mostrarCursos= true;
			boolean cursoEncontrado;

			while(mostrarCursos) {

				System.out.print("=====\t Cursos disponiveis \t=====\n");

				if (cursos.size()>=quantidadeListados) {
					for(int i=indiceInicial;i<quantidadeListados;i++) {
						System.out.printf("%d-%s",i+1,cursos.get(i).toString());
					}

				}else{
					for(int i=indiceInicial;i<cursos.size();i++) {
						System.out.printf("%d-%s",i+1,cursos.get(i).toString());
						quantidadeListados=cursos.size();//informacao usada no proximo for
					}
				}
				System.out.println("=====\t Escolha uma opção \t=====");
				System.out.print("1- Detalhar curso, 2- Comprar curso, 3- Exibir mais 10 cursos, 4- Voltar \n");

				opcaoCurso=entrada.nextInt();
				entrada.nextLine();//limpando o buffer do teclado

				// detalha o curso
				if(opcaoCurso == 1) {
					System.out.println("Infome codigo do curso:");
					codigoCurso=entrada.nextLine();

					Curso cursoEscolhido = null;
					for(Curso curso: cursos) {
						if(curso.getCodigo().equals(codigoCurso)) {
							cursoEscolhido = curso;
						}
					}

					if(cursoEscolhido == null) {
						System.out.println("Curso não encontrado!");
					}

					else if(cursoEscolhido instanceof CursoVagas) {
						CursoVagas cursoVagas = (CursoVagas) cursoEscolhido;
						System.out.printf("Dados do curso: \n %s Criador: %s \n Inicia: %s \n Encerra:%s\n Quantidade de vagas: %d \n", cursoVagas, cursoVagas.getCriador().getNome(), formatadorDeData.format(cursoVagas.getDataComeco().getTime()) ,formatadorDeData.format(cursoVagas.getDataEncerramento().getTime()), cursoVagas.getVagas());

					} 
					else if(cursoEscolhido instanceof CursoAoVivo) {
						CursoAoVivo cursoAoVivo = (CursoAoVivo) cursoEscolhido;
						System.out.printf("Dados do curso: \n %s Criador: %s \n Inicia: %s \n Encerra: %s \n", cursoAoVivo, cursoAoVivo.getCriador().getNome(), formatadorDeData.format(cursoAoVivo.getDataComeco().getTime()),formatadorDeData.format(cursoAoVivo.getDataEncerramento().getTime()));

					}else {
						System.out.println(cursoEscolhido);

					}
					
					System.out.println("Deseja continuar? 1- Sim 2- Nao");
					escolha=entrada.nextInt();
					entrada.nextLine();

					if(escolha != 1) {
						mostrarCursos = false;
					}
				}
				// efetuar a compra de algum curso
				else if (opcaoCurso == 2) {

					if(comprador == null) {
						System.out.println("Usuario precisa esta autenticado para fazer uma compra");
					} else {
						System.out.println("Infome codigo do curso:");
						codigoCurso=entrada.nextLine();
						boolean encerrou = false;
						boolean naoecontrado = false;
						
						// procura pelo curso
						for(Curso compraCurso : cursos) {
							if(compraCurso.getCodigo().equals(codigoCurso)) {
								if(compraCurso instanceof CursoVagas) {
									CursoVagas cursoVaga = (CursoVagas) compraCurso;
									
									// diminui a quantidade de vagas e caso já tenha esgotado retorna uma excessão
									try {
										cursoVaga.diminuirVagas(cursoVaga.getVagas() - 1);

									} catch (MensagemError e) {
										System.out.println(e.getMessage());
										encerrou = true;
									}

								}
								// verfica se o curso terminou a quantidade de vagas
								if(encerrou == true) {
									System.out.println("Não foi possível efetuar a compra");
									break;
								} else {
									// faz a compra, armazena e retorna o código da compra
									Compra cursoCompra = new Compra(compraCurso, comprador);

									BancoDeDados.armazenarCompra(cursoCompra);

									System.out.println("Curso comprado com sucesso");
									System.out.printf("O codigo da sua compra: %s \n", cursoCompra.getCodigo());
									break;
								}
							} else {
								naoecontrado = true;
							}

						}
						
						if(naoecontrado == true) {
							System.out.println("O curso não encontrado");
						}
						
					}
					System.out.println("Deseja continuar? 1- Sim 2- Não");
					escolha=entrada.nextInt();
					entrada.nextLine();

					if(escolha != 1) {
						mostrarCursos = false;
					}

				} else if(opcaoCurso == 3) {
					quantidadeListados+=10;
					indiceInicial+=10;
				} else {
					mostrarCursos = false;
				}

			}

		}else {
			System.out.println("Nao ha cursos cadastrados");
		}
	}

	// função de criar curso
	public void criarCurso(Usuario usuario, Scanner entrada) {
		if (usuario != null && usuario.getAutenticado() == true && usuario.getAdmin() != true) {
			System.out.print("Informe nome do curso:");
			String nomeCurso = entrada.nextLine();
			System.out.print("Informe tipo do curso (1- Gravado com tempo de acesso indeterminado\t2- Com limite de vagas\t3- Ao vivo\t 4- gravado com tempo de acesso determinado):");
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
				System.out.println("Informe hora que inicia o curso(Hora que come�a a aula ou o acesso ao curso):");
				int horaIni = entrada.nextInt();
				System.out.println("Informe minuto que inicia o curso:");
				int minutoIni = entrada.nextInt();
				System.out.println("Informe dia que encerra o curso:");
				int diaEnc = entrada.nextInt();
				System.out.println("Informe mes que encerra o curso:");
				int mesEnc = entrada.nextInt();
				System.out.println("Informe ano que encerra o curso:");
				int anoEnc = entrada.nextInt();
				System.out.println("Informe hora que encerra o curso(Hora que encerra a aula ou o acesso ao curso):");
				int horaEnc = entrada.nextInt();
				System.out.println("Informe minuto que encerra o curso:");
				int minutoEnc = entrada.nextInt();
				GregorianCalendar dataInicial = new GregorianCalendar();
				GregorianCalendar dataFinal = new GregorianCalendar();

				formatadorDeData.setLenient(false);
				
				
				try{
				dataInicial.setTime(formatadorDeData.parse(String.format("%d-%d-%d %d:%d",diaIni,mesIni,anoIni, horaIni, minutoIni)));
		
					try {
						dataFinal.setTime(formatadorDeData.parse(String.format("%d-%d-%d %d:%d",diaEnc,mesEnc,anoEnc, horaEnc, minutoEnc)));	
					   
						if(dataInicial.before(dataFinal)) {
						     
							boolean cursoForaDoIntervalo=true;
							
							while(cursoForaDoIntervalo) {	
								for(int i=0; i<BancoDeDados.lerArmazenamentoCursos().size();i++) {
									
										if(BancoDeDados.lerArmazenamentoCursos().get(i).getCriador()==usuario && BancoDeDados.lerArmazenamentoCursos().get(i) instanceof CursoAoVivo) {
											
											CursoAoVivo cursoDoCriador2 = (CursoAoVivo) BancoDeDados.lerArmazenamentoCursos().get(i); 
											
											if((cursoDoCriador2.getDataEncerramento().before(dataInicial) && cursoDoCriador2.getDataComeco().before(dataFinal))||(cursoDoCriador2.getDataEncerramento().after(dataInicial) && cursoDoCriador2.getDataComeco().after(dataFinal))) {
												cursoForaDoIntervalo=true;
											}
											else {
												cursoForaDoIntervalo=false;
											}
																
										}else {
											
											cursoForaDoIntervalo=true;//Caso o usuario ainda n�o tenha nenhum curso ao vivo cadastrado
										}	
								}
								if(cursoForaDoIntervalo) {
									if (tipoCurso == 2) {
									
										System.out.println("Informe numero de vagas:");
										int vagas = entrada.nextInt();
										Curso curso = new CursoVagas(nomeCurso,preco,usuario, dataInicial,dataFinal, vagas);
										BancoDeDados.armazenarCurso(curso);
										
									}else if (tipoCurso == 3) {
										if(horaEnc>=horaIni) {
											if(minutoEnc>=minutoIni|| horaEnc>horaIni){
												Curso curso = new CursoAoVivo(nomeCurso, preco, usuario, dataInicial,dataFinal);
												BancoDeDados.armazenarCurso(curso);
											}else {
												System.out.println("Curso nao criado: horario de enceramento da aula nao deve ser anterior ao horario inicial");
												
											}
											
										}else {
											System.out.println("Curso nao criado: horario de enceramento da aula nao deve ser anterior ao horario inicial");
										}
										
									}else if(tipoCurso==4) {
										Curso curso = new CursoAoVivo(nomeCurso, preco, usuario, dataInicial,dataFinal);
										BancoDeDados.armazenarCurso(curso);	
									}else {
										System.out.println("Opcao invalida");
									}
									
									cursoForaDoIntervalo=false;//para encerrar o while	
								}else {
									System.out.println("Curso nao cadastrado, data conflitante");
								}
							}
								
						}else {
							   System.out.println("Curso nao cadastrado, data final invalida");
							   
						   }
					}catch(ParseException e) {
							
							System.out.println("Curso n�o cadastrado, data Final inv�lida");
						}
				}catch(ParseException e) {
					
					System.out.println("Curso n�o cadastrado, data inicial inv�lida");
				}
			
			}else {
				Curso curso = new Curso(nomeCurso, preco, usuario);
				BancoDeDados.armazenarCurso(curso);
			}
		}else {
			System.out.println("Para criar um curso o usuário precisa tá autenticado!");
		}
	}

	// função de editar
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
			
			boolean cursoEditarEncontrado=false;//variavel que informar se o curso foi encontrado
			for(int i=0; i<BancoDeDados.lerArmazenamentoCursos().size();i++) {
				Curso cursoEditar = BancoDeDados.lerArmazenamentoCursos().get(i);
				
				// verifica se o criador do curso corresponde com o usuario autenticado
				if(cursoEditar.getCodigo().equals(escolhaCursoEditar) && cursoEditar.getCriador().equals(usuario)) {
					cursoEditarEncontrado = true;
					
					System.out.print("Informe nome do curso:");
					cursoEditar.setNomeCurso(entrada.nextLine());

					System.out.print("Informe valor do curso:");
					cursoEditar.setPreco(entrada.nextDouble());
					entrada.nextLine();
					
					// edita o curso do tipo ao vivo
					 if (cursoEditar instanceof CursoAoVivo) {
						CursoAoVivo cursoIndividualEditar = (CursoAoVivo) cursoEditar;
						GregorianCalendar dataComeco = new GregorianCalendar();
						System.out.println("Informe data(no formato dd-MM-yyyy HH:mm) que inicia o curso:");
						String comeco=entrada.nextLine();
						
						if(comeco!=null) {
							
							try {
								dataComeco.setTime(formatadorDeData.parse(comeco));
								
							} catch (ParseException e) {
								System.out.println("Data inicial invalida");
							}
						}
						
						
						GregorianCalendar dataEncerramento = new GregorianCalendar();
						System.out.println("Informe data(no formato dd/MM/yyyy HH:mm) que encerra o curso:");
						String encerramento=entrada.nextLine();
						boolean cursoForaDoIntervalo2=false;//variavel que informa se o curso esta em uma data viavel
						if(encerramento!=null) {
							
							try {
								dataEncerramento.setTime(formatadorDeData.parse(encerramento));
								if(dataEncerramento.after(dataComeco)) {
									for(int j=0; j<BancoDeDados.lerArmazenamentoCursos().size();j++) {
										if(BancoDeDados.lerArmazenamentoCursos().get(i).getCriador()==usuario && BancoDeDados.lerArmazenamentoCursos().get(i) instanceof CursoAoVivo) {
											CursoAoVivo cursoEditarData;
											cursoEditarData = (CursoAoVivo) BancoDeDados.lerArmazenamentoCursos().get(i);
											
											if((cursoEditarData.getDataEncerramento().before(dataComeco) && cursoEditarData.getDataComeco().before(dataEncerramento))||(cursoEditarData.getDataEncerramento().after(dataComeco) && cursoEditarData.getDataComeco().after(dataComeco))) {
												cursoForaDoIntervalo2=true;
											}
											else {
												cursoForaDoIntervalo2=false;
											}
										}	
									}
										if(cursoForaDoIntervalo2) {
											cursoIndividualEditar.setDataComeco(dataComeco);
											cursoIndividualEditar.setDataEncerramento(dataEncerramento);
										}	
						
										
									
								
								}else{
									System.out.println("Data de encerramento nao pode ser anterior a data de inicio");
								}
							
							} catch (ParseException e) {
								System.out.println("Data de Encerramento invalida");
							}
						}
						
						// edita o curso do tipo vagas
						if (cursoEditar instanceof CursoVagas && cursoForaDoIntervalo2) {
							CursoVagas cursoAoVivoEditar = (CursoVagas) cursoEditar;
							
							System.out.println("Informe numero de vagas:");
							try {
								cursoAoVivoEditar.setVagas(entrada.nextInt());
							} catch (MensagemError e) {
								// TODO Auto-generated catch block
								System.out.println(e.getMessage());
							}
							
						}	
					}

					System.out.println("Alteração feita com sucesso!");
					break;
				} 
			}
		if(cursoEditarEncontrado==false) {
				System.out.println("Tivemos um problema, por favor tente novamente mais tarde.");
			}
		}
	}

	// função de remover curso
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

			// procura pelo curso e deleta
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
