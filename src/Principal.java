import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

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

		Administrador admin = new Administrador("Root", "Admin", "admin@gmail.com", "root123", "99999999", "12345678900", "44444444", "admin",false);
		BancoDeDados.armazenarUsuario(admin);
		

		while(ativo) {
			//System.out.println(BancoDeDados.lerArmazenamentoUsuarios());
			System.out.print("====== \t Menu principal \t ====== \n");
			System.out.print("\t 0 - Registrar \n");
			System.out.print("\t 1 - Login \n");
			System.out.print("\t 2 - Listar cursos \n");
			System.out.print("\t 3 - Criar curso \n");
			System.out.print("\t 4 - Visualizar usuários \n");
			System.out.print("\t 5 - Ver usuários \n");
			System.out.print("\t 6 - Ver usuários \n");
			System.out.print("\t 7 - alguma função \n");
			System.out.print("\t 8 - Desconectar \n");
			System.out.print("\t 9 - Sair \n");
			System.out.print("\n\nEscolha sua opção: ");
			options = entrada.nextInt();

			System.out.println();

			switch(options) {
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
				break;
			case 1:
				System.out.print("Digite o seu email:\t");
				email = entrada.next();

				System.out.print("Digite o seu senha:\t");
				senha = entrada.next();

				autenticacao.login(email, senha);
				break;

			case 2:

				break;

			case 3:
				autenticacao.desconectar();
				
					System.out.println("Informe nome do curso:");
					String nomeCurso = entrada.next();
					System.out.println("Informe tipo do curso(1-Gravado,2-Ao Vivo 3-Individual):");
					int tipoCurso = entrada.nextInt();
					System.out.println("Informe valor do curso:");
					Double preco = entrada.nextDouble();
					
					if(tipoCurso!=1){
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
						
						if(tipoCurso==2) {
							System.out.println("Informe numero de vagas:");
							int vagas = entrada.nextInt();
							Curso curso = new Curso(nomeCurso,"codigo",preco,vagas,false,
									true,false,diaIni, mesIni, anoIni, horaIni, minutoIni, diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc);
							BancoDeDados.armazenarCurso(curso);}
						
						if(tipoCurso==3) {
							Curso curso= new Curso(nomeCurso,"codigo",preco,false,false,true,diaIni, mesIni, anoIni, horaIni, minutoIni, diaEnc, mesEnc, anoEnc, horaEnc, minutoEnc);
						BancoDeDados.armazenarCurso(curso);
					}
					}
					else{	
						Curso curso= new Curso(nomeCurso,"codigo",preco,true,false,false);
						BancoDeDados.armazenarCurso(curso);
							}
						
							break;
			case 4:
				ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();

				boolean adm = false;
				for(int i = 0; i < usuarios.size(); i++) {
					if(usuarios.get(i).getTipo() == "admin" && usuarios.get(i).getAutenticado() == true) {

						adm = true;
					}
				}

				if(adm) {
					System.out.println(usuarios);

				} else {
					System.out.println("Usuário não é administrador!");
				}

				break;
			case 5:
				ativo = false;
				break;
			case 6:
				ativo = false;
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