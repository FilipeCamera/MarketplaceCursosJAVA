import java.util.ArrayList;

public class Validacao {
	public void validacaoRegistrar(String email, String senha, String cpf, String cep, String telefone) throws MensagemError {

		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();


		if(email.length() == 0 || email.indexOf("@") <= 0) {
			throw new MensagemError("Seu email não é válido");
		}
		else if(senha.length() == 0 || senha.length() < 6) {
			throw new MensagemError("A senha tem que ser maior ou igual que 6 caracteres, tente novamente!");
		}
		else if(cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.length() != 11) {
			throw new MensagemError("CPF inválido, tente novamente!");
		}
		else if(cep.length() < 8 || cep.length() > 9) {
			throw new MensagemError("CEP inválido, tente novamente!");
		}
		else if(telefone.length() == 0 || telefone.length() < 8 || telefone.length() > 11) {
			throw new MensagemError("Número de telefone inválido, tente novamente!");
		}
		else if(usuarios.size() != 0) {
			for(int i = 0; i < usuarios.size(); i++) {
				if (email == usuarios.get(i).getEmail()) {
					throw new MensagemError("Usuário já existe!");
				}
			}
		}

	}
	public void validacaoLogin(String email, String senha) throws MensagemError {
		if(email.length() == 0 || email.indexOf("@") <= 0) {
			throw new MensagemError("Seu email não é válido, tente novamente!");
		}
		else if(senha.length() == 0 || senha.length() < 6) {
			throw new MensagemError("A senha tem que ser maior que 6 caracteres, tente novamente!");
		}

		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();
		
		if(usuarios.size() == 0) {
			throw new MensagemError("Nenhum usuário cadastrado!");
		}
		for(int i = 0; i < usuarios.size(); i++) {
			if (email == usuarios.get(i).getEmail() && senha != usuarios.get(i).getSenha()) {
				throw new MensagemError("E-mail ou senha incorretas!");
			}
		}


	}
}
