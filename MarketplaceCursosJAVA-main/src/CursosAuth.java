
public class CursosAuth {
	
	private Cursos curso;
	private Validacao_Cursos validacao = new Validacao_Cursos();
	
	public CursosAuth () {}
		public void register(String nome_curso, int carga_h, int prazo, float preco, int vagas_aovivo) {
			
			try {
			this.validacao.validacaoRegister(carga_h, prazo, preco, vagas_aovivo);
			
			this.curso = new Cursos(nome_curso, carga_h, prazo, preco);
			
			BancoDeDados.armazenarCurso(this.curso);
			System.out.printf("Curso registrado com sucesso! \n");
		} catch (MensagemError e) {
			// TODO Auto-generated catch block
			System.out.printf("%s", e.getMessage());
		}
				
			}
				
				
			
			
		}
		
		
	
	

