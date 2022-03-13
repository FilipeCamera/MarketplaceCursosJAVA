import java.util.ArrayList;

// Classe Validacao - responsavel por validar alguns dados que o usu�rio passa;

public class Validacao {
	private ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();

	
	// fun��o que valida alguns dados antes de registrar
	public void validacaoRegistrar(String email, String senha, String cpf, String cep, String telefone) throws MensagemError {

		// verifica o e-mail
		if(email.length() == 0 || email.indexOf("@") <= 0) {
			throw new MensagemError("Seu email n�o � v�lido");
		}
		// verifica a senha
		else if(senha.length() == 0 || senha.length() < 6) {
			throw new MensagemError("A senha tem que ser maior ou igual que 6 caracteres, tente novamente!");
		}
		// verifica o cpf
		else if(cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.length() != 11) {
			throw new MensagemError("CPF inv�lido, tente novamente!");
		}
		// verifica o cep
		else if(cep.length() < 8 || cep.length() > 9) {
			throw new MensagemError("CEP inv�lido, tente novamente!");
		}
		// verifica o telefone
		else if(telefone.length() == 0 || telefone.length() < 8 || telefone.length() > 11) {
			throw new MensagemError("N�mero de telefone inv�lido, tente novamente!");
		}
		// verifica se ja existe esse usuario
		else if(this.usuarios.size() != 0) {
			for(int i = 0; i < this.usuarios.size(); i++) {
				if (email == this.usuarios.get(i).getEmail()) {
					throw new MensagemError("Usu�rio j� existe!");
				}
			}
		}

	}
	// fun��o que faz a valida��o antes de efetuar o login
	public void validacaoLogin(String email, String senha) throws MensagemError {
		
		// verifica o email
		if(email.length() == 0 || email.indexOf("@") <= 0) {
			throw new MensagemError("Seu email n�o � v�lido, tente novamente!");
		}
		// verifica a senha
		else if(senha.length() == 0 || senha.length() < 6) {
			throw new MensagemError("A senha tem que ser maior que 6 caracteres, tente novamente!");
		}
		
		// verifica se existe algum usuário cadastrado na plataforma
		else if(this.usuarios.size() == 0) {
			throw new MensagemError("Nenhum usu�rio cadastrado!");
		}
		
		// verifica se os dados passado pelo usuario corresponde com que tem cadastrado na plataforma,
		// no caso, verifica se a senha esta correta
		for(int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i).getEmail().equals(email) && !this.usuarios.get(i).getSenha().equals(senha)) {
				throw new MensagemError("E-mail ou senha incorretas!");
			}
		}


	}
}
