import java.util.ArrayList;

public class TelaCompras {
	
	private ArrayList<Compra> compras = BancoDeDados.lerArmazenamentoCompras();
	
	public void minhasCompras(Usuario usuario) {
		if(usuario!=null && usuario.getAutenticado()==true && compras.size()!=0) {
			
			for(int i=0;i<compras.size();i++) {
				if(compras.get(i).getComprador().equals(usuario)) {
					System.out.printf("%d-%s",i+1,compras.get(i).toString());
				}
			
			}
		}else {
			System.out.println("Usuario nao autenticado ou nao ha compras registradas");
		}
	}
}
