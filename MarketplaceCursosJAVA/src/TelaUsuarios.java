import java.util.Scanner;

/* Classe TelaUsuarios - responsável por mostrar os usuários cadastrados na plataforma se o usuário 
 for administrador */

public class TelaUsuarios {
	private int quantidadeListados = 10;
	private int expandirLista;
	private boolean mostrarUsuarios = true;

	// função de mostrar os usuários
	public void listarUsuarios(Usuario usuario, Scanner entrada) throws MensagemError {
		// verifica se tem algum usuário autenticado
		if(usuario == null || usuario.getAutenticado() != true) {
			throw new MensagemError("Usuário não autenticado");
		}
		// verifca se o usuário é admin
		else if (usuario.getAdmin() == true) {
			if(BancoDeDados.lerArmazenamentoUsuarios().size()!=0) {
				while(mostrarUsuarios) {

					System.out.print("=====\t Usuários cadastrados na plataforma \t=====\n");

					if (BancoDeDados.lerArmazenamentoUsuarios().size()>=this.quantidadeListados) {
						for(int i=0;i<this.quantidadeListados;i++) {
							System.out.println(BancoDeDados.lerArmazenamentoUsuarios().get(i) + "\t" + "Cursos criado: " + BancoDeDados.lerArmazenamentoUsuarios().get(i).getQuantCursoCriado());

						}

					}else{
						for(int i=0;i<BancoDeDados.lerArmazenamentoUsuarios().size();i++) {
							System.out.println(BancoDeDados.lerArmazenamentoUsuarios().get(i) + "\t" + "Cursos criado: " + BancoDeDados.lerArmazenamentoUsuarios().get(i).getQuantCursoCriado());
							this.quantidadeListados=BancoDeDados.lerArmazenamentoUsuarios().size();
						}
					}

					System.out.println("Listar mais 10 usuários? 1-Sim, 2-Nao 3-encerrar");
					this.expandirLista=entrada.nextInt();
					if(this.expandirLista==1){
						this.quantidadeListados+=10;//permite mostrar mais 10 cursos
					}
					else if(this.expandirLista==3) {
						this.mostrarUsuarios=false;//encerra a listagem de cursos
					}
					else {
						break;
					}
				}


			}else {
				throw new MensagemError("Nenhum usuário cadastrado");
			}
		}
		else {
			throw new MensagemError("Função permitida somente para administradores");
		}
	}
}
