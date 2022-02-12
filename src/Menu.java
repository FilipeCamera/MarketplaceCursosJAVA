import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

	public Menu() {
	}

	public void executar() {
		String nome;
		String sobrenome;
		String email;
		String senha;
		String cpf;
		String cep;
		String telefone;
		int options;
		boolean ativo = true;

		UsuarioAuth autenticacao;

		Scanner entrada = new Scanner(System.in);
		autenticacao = new UsuarioAuth();
		Usuario usuario = null;

		Usuario administrador = new Usuario("Root", "Admin", "admin@gmail.com", "root123", "99999999", "12345678900",
				"44444444", true, false);
		BancoDeDados.armazenarUsuario(administrador);

		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();
		ArrayList<Curso> cursos = BancoDeDados.lerArmazenamentoCursos();

		while (ativo) {
			// System.out.println(BancoDeDados.lerArmazenamentoUsuarios());
			System.out.print("====== \t Menu principal \t ====== \n");
			System.out.print("\t 0 - Registrar \n");
			System.out.print("\t 1 - Login \n");
			System.out.print("\t 2 - Listar cursos \n");
			System.out.print("\t 3 - Criar curso \n");
			System.out.print("\t 4 - Editar curso \n");
			System.out.print("\t 5 - Excluir curso \n");
			System.out.print("\t 6 - Ver usuários \n");
			System.out.print("\t 7 - alguma função \n");
			System.out.print("\t 8 - Desconectar \n");
			System.out.print("\t 9 - Sair \n");
			System.out.print("\n\nEscolha sua opção: ");
			options = entrada.nextInt();
			entrada.nextLine();

			switch (options) {
			case 0:
				System.out.print("Digite o seu nome: ");
				nome = entrada.nextLine();

				System.out.print("Digite o seu sobrenome: ");
				sobrenome = entrada.nextLine();

				System.out.print("Digite o seu email: ");
				email = entrada.nextLine();

				System.out.print("Digite o seu senha: ");
				senha = entrada.nextLine();

				System.out.print("Digite o seu cpf: ");
				cpf = entrada.nextLine();

				System.out.print("Digite o seu cep: ");
				cep = entrada.nextLine();

				System.out.print("Digite o seu telefone: ");
				telefone = entrada.nextLine();

				autenticacao.registrar(nome, sobrenome, email, senha, telefone, cpf, cep);
				usuario = autenticacao.getUsuario();
				break;
			case 1:
				System.out.print("Digite o seu email:\t");
				email = entrada.next();

				System.out.print("Digite o seu senha:\t");
				senha = entrada.next();

				autenticacao.login(email, senha);
				usuario = autenticacao.getUsuario();
				break;

			case 2:
				System.out.print("=====\t Cursos disponíveis \t=====\n");
				System.out.println(cursos);
				break;

			case 3:
				String codigo = UUID.randomUUID().toString();
				if (usuario.getAutenticado() == true) {
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
							Curso curso = new Curso(nomeCurso, codigo, preco, vagas, false,
									true, false, diaIni, mesIni, anoIni, horaIni, minutoIni, diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc,
									usuario.getId());
							BancoDeDados.armazenarCurso(curso);
						}

						if (tipoCurso == 3) {
							Curso curso = new Curso(nomeCurso, codigo, preco, false, false, true, diaIni, mesIni, anoIni, horaIni,
									minutoIni, diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc, usuario.getId());
							BancoDeDados.armazenarCurso(curso);
						}
					} else {
						Curso curso = new Curso(nomeCurso, codigo, preco, true, false, false, usuario.getId());
						BancoDeDados.armazenarCurso(curso);
					}

				} else {
					System.out.println("Para criar um curso o usuário precisa tá autenticado!");
				}

				break;
			case 4:
				String escolhaCursoEditar;
				if(usuario.getAutenticado() != true) {
					System.out.println("Usuário precisa está autenticado para editar algum curso");
				} else {
					for(Curso cursoEditar : cursos) {
						if(cursoEditar.getUsuarioId().equals(usuario.getId())) {
							System.out.println("=====\t Seus cursos \t=====");
							System.out.println(cursoEditar);
						}
					}
					System.out.print("Escolha o curso que quer editar (código): ");
					escolhaCursoEditar = entrada.nextLine();

					for(Curso cursoEditar : cursos) {
						if(cursoEditar.getCodigo().equals(escolhaCursoEditar) && cursoEditar.getUsuarioId().equals(usuario.getId())) {
							System.out.print("Informe nome do curso:");
							cursoEditar.setNomeCurso(entrada.nextLine());
							System.out.print("Informe tipo do curso (1-Gravado,2-Ao Vivo 3-Individual):");
							int tipoCurso = entrada.nextInt();
							entrada.nextLine();
							System.out.print("Informe valor do curso:");
							cursoEditar.setPreco(entrada.nextDouble());

							if (tipoCurso != 1) {
								System.out.println("Informe dia que inicia o curso:");
								cursoEditar.setDiaIni(entrada.nextInt());
								System.out.println("Informe mes que inicia o curso:");
								cursoEditar.setMesIni(entrada.nextInt());
								System.out.println("Informe ano que inicia o curso:");
								cursoEditar.setAnoIni(entrada.nextInt());
								System.out.println("Informe hora que inicia o curso:");
								cursoEditar.setHoraIni(entrada.nextInt());
								System.out.println("Informe minuto que inicia o curso:");
								cursoEditar.setMinutoIni(entrada.nextInt());
								System.out.println("Informe dia que encerra o curso:");
								cursoEditar.setDiaEnc(entrada.nextInt());
								System.out.println("Informe mes que encerra o curso:");
								cursoEditar.setMesEnc(entrada.nextInt());
								System.out.println("Informe ano que encerra o curso:");
								cursoEditar.setAnoEnc(entrada.nextInt());
								System.out.println("Informe hora que encerra o curso:");
								cursoEditar.setHoraEnc(entrada.nextInt());
								System.out.println("Informe minuto que encerra o curso:");
								cursoEditar.setMinutoEnc(entrada.nextInt());

								if (tipoCurso == 2) {
									System.out.println("Informe numero de vagas:");
									cursoEditar.setVagas(entrada.nextInt());

								}
							}

							System.out.println("Alteração feita com sucesso!");
							break;
						} else {
							System.out.println("Tivemos um problema, por favor tente novamente mais tarde.");
							break;
						}
					}
				}
				break;
			case 5:
				String escolhaCursoDeletar;
				if(usuario.getAutenticado() != true) {
					System.out.println("Usuário precisa está autenticado para editar algum curso");
				} else {
					for(Curso cursoDeletar : cursos) {
						if(cursoDeletar.getUsuarioId().equals(usuario.getId())) {
							System.out.println("=====\t Seus cursos \t=====");
							System.out.println(cursoDeletar);
						}
					}
					System.out.print("Escolha o curso que quer editar (código): ");
					escolhaCursoDeletar = entrada.nextLine();

					for(Curso cursoDeletar : cursos) {
						if(cursoDeletar.getCodigo().equals(escolhaCursoDeletar) && cursoDeletar.getUsuarioId().equals(usuario.getId())) {

							cursos.remove(cursoDeletar);


							System.out.println("Curso excluido com sucesso!");
							break;
						} else {
							System.out.println("Tivemos um problema, por favor tente novamente mais tarde.");
							break;
						}
					}
				}
				break;
			case 6:
				if (usuario.getAdmin() == true) {
					System.out.println(usuarios);
				} else {
					System.out.println("Usuário não tem esse privilégio, você precisa ser administrador");
				}
				break;
			case 7:
				ativo = false;
				break;
			case 8:
				autenticacao.desconectar();
				break;
			case 9:
				ativo = false;
				break;
			}

		}
		System.out.print("====== \t Muito Obrigado por usar nossa plataforma \t =====\n\n");
	}
}
