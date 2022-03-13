import java.util.Scanner;

/* Classe TelaUsuarios - responsável por mostrar os usuários cadastrados na plataforma se o usurio 
 for administrador */

public class TelaUsuarios {
	private int quantidadeListados = 10;
	private int expandirLista;
	private boolean mostrarUsuarios = true;

	// função de mostrar os usuários
	public void listarUsuarios(Usuario usuario, Scanner entrada) throws MensagemError {
		// verifica se tem algum usuÃ¡rio autenticado
		if(usuario == null || usuario.getAutenticado() != true) {
			throw new MensagemError("Usuario não autenticado");
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

					System.out.println("Listar mais 10 usuarios? 1-Sim, 2-Nao 3-encerrar");
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
			System.out.println("Deseja listar vendas?1-Sim 2-Nao");
			int listarVendas = entrada.nextInt();
			if(listarVendas==1 && BancoDeDados.lerArmazenamentoCompras().size()!=0) {
				for(int j=0;j<BancoDeDados.lerArmazenamentoCompras().size();j++) {
					System.out.printf("%d-%s",j+1,BancoDeDados.lerArmazenamentoCompras().get(j));
				}
				System.out.println("Deseja ver receita total das taxas sobre vendas? 1-SIM 2- NAO");
				int verReceita = entrada.nextInt();
				entrada.nextLine();
				if(verReceita==1){
					double receita=0;
					for(int i=0;i<BancoDeDados.lerArmazenamentoCompras().size();i++) {
							receita+=BancoDeDados.lerArmazenamentoCompras().get(i).getCurso().getPreco()*0.05;
						}
					System.out.printf("A receita total das taxas sobre vendas é de: R$ %.2f \n",receita);
				}
			}else {
			System.out.println("Ainda nao houve compras");
			}
		}
		else {
			throw new MensagemError("Função permitida somente para administradores");
		}
	}
}
