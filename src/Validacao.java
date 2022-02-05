import java.util.ArrayList;

public class Validacao {
	public void validacaoRegistrar(String email, String senha, String cpf, String cep, String telefone) throws MensagemError {
		if(email.length() == 0) {
			throw new MensagemError("Seu email não é válido");
		}
		else if(senha.length() == 0 && senha.length() <= 6) {
			throw new MensagemError("A senha tem que ser maior que 6 caracteres, tente novamente!");
		}
		else if(telefone.length() == 0) {
			throw new MensagemError("Número de telefone inválido, tente novamente!");
		}
		else if(cpf.length() == 0) {
			throw new MensagemError("CPF inválido, tente novamente!");
		}
		else if(cep.length() == 0) {
			throw new MensagemError("CEP inválido, tente novamente!");
		}
		
		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();
		
		for(int i = 0; i <= usuarios.size(); i++) {
			if (email == usuarios.get(i).getEmail()) {
				throw new MensagemError("Usuário já existe!");
			}
		}

	}
	public void validacaoLogin(String email, String senha) throws MensagemError {
		if(email.length() == 0) {
			throw new MensagemError("Seu email não é válido, tente novamente!");
		}
		else if(senha.length() == 0 && senha.length() <= 6) {
			throw new MensagemError("A senha tem que ser maior que 6 caracteres, tente novamente!");
		}

		ArrayList<Usuario> usuarios = BancoDeDados.lerArmazenamentoUsuarios();

		for(int i = 0; i <= usuarios.size(); i++) {
			if (email == usuarios.get(i).getEmail() && senha != usuarios.get(i).getSenha()) {
				throw new MensagemError("E-mail ou senha incorretas!");
			}
		}


	}
}
