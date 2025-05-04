package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO{

	/**
	 * Construtor padrão para criação de uma nova instanciad da pagina de login.
	 * @param driver
	 */
	public LoginPO(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id="email")
	private WebElement inputEmail;
	
	@FindBy(id="senha")
	private WebElement inputSenha;
	
	@FindBy(id="btn-entrar")
	private WebElement btnEntrar;

	@FindBy(css="form.form-login>div.alert>span")
	private WebElement mensagemErro;
	
	/**
	 * Escreve no campo email o texto passado no método.
	 * @param email
	 */
	public void escreveEmail(String email) {
		limparCampo(inputEmail);
		escrever(inputEmail, email);
	}
	
	/**
	 * Escreve no campo senha o texto passado no método.
	 * @param senha
	 */
	public void escreveSenha(String senha) {
		limparCampo(inputSenha);
		escrever(inputSenha, senha);
	}
	
	/**
	 * Realiza a ação de clicar no botão entrar da tela de login.
	 */
	public void clicarBotaoEntrar() {
		clicarBotao(btnEntrar);
	}
	
	/**
	 * Obtem a mensagem de erro apresentada ao usuário ao tentar realizar login de forma incorreta.
	 * @return
	 */
	public String obtemMensagemErro() {
		return obtemTexto(mensagemErro);
	}
	
	/**
	 * Realiza a execução do login passando um email e uma senha como parametro e realizando o clique no botão de entrar.
	 * @param email
	 * @param senha
	 */
	public void executarAcaoDeLogar(String email, String senha) {
		escreveEmail(email);
		escreveSenha(senha);
		clicarBotaoEntrar();
	}
}
