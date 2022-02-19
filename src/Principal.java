public class Principal {

	public static void main(String[] args) {
		boolean carregado = false;
		
		LoadingBancoDeDados loadingBd = new LoadingBancoDeDados();
		Menu menu = new Menu();
		
		System.out.print("Carregando...");
		
		carregado = loadingBd.carregar();
		
		if(carregado) {
			menu.exibirMenu();
		} else {
			System.out.println("Ocorreu um problema ao carregar a plataforma, por favor tente mais tarde!");
		}
		
	}

}
