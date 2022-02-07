import java.util.ArrayList;

public class Validacao_Cursos {
	public void validacaoRegister(int carga_h, int prazo, float preco, int vagas_aovivo) throws MensagemError {
		if(carga_h <=0 ) {
			throw new MensagemError("A carga horaria esta negativa ou zerada ");
		}
		else if (prazo <= 0) {
			throw new MensagemError("O prazo disponivel esta errado");
		}else if (preco < 0) {
			throw new MensagemError("Valor negativo");
		}else if (vagas_aovivo == 0) {
			throw new MensagemError("O prazo disponivel esta errado");
		}
		
		}
	//ArrayList<Cursos> cursos = BancoDeDados.lerArmazenamentoCursos();

}
