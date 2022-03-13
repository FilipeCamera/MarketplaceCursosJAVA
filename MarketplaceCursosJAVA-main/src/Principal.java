//Classe que carrega o banco dedados e exibe o menu para o usuário
public class Principal {

	public static void main(String[] args) {
		boolean carregado = false;
		
		LoadingBancoDeDados loadingBd = new LoadingBancoDeDados();
		Menu menu = new Menu();
		
		System.out.print("Carregando...");
		
		// carrega o Banco de dados
		carregado = loadingBd.carregar();
		
		
		// exibe o menu se tiver carregado o banco de dados
		if(carregado) {
			menu.exibirMenu();
		} else {
			System.out.println("Ocorreu um problema ao carregar a plataforma, por favor tente mais tarde!");
		}
		
	}

}
