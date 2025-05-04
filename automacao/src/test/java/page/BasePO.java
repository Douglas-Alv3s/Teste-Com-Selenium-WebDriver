package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Classe base para criação das novas PagesObjects.
 * Todas as pages devem ser herdadas desta classe.
 */
public abstract class BasePO {
	
	/** Driver Base que será usado pelas pages */
	protected WebDriver driver;
	
	/**
	 * Construtor base para criação da fabrica de elementos (PageFactory).
	 * @param driver - Driver da pagina atual.
	 */
	protected BasePO(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Método para escrever em campo de texto. Recebendo um WebElement que será utilizado e o texto a ser escrito.
	 * @param elemento
	 * @param texto
	 */
	public void escrever(WebElement elemento, String texto) {
		limparCampo(elemento);
		elemento.sendKeys(texto);
	}

	/**
	 * Clica no botão informado no método.
	 * @param elemento
	 */
	public void clicarBotao(WebElement elemento) {
		elemento.click();
	}

	/**
	 * Passa um elemento e recebe o retorno do que está escrito no texto.
	 * @param txtElemento
	 * @return
	 */
	public String obtemTexto(WebElement txtElemento) {
		return txtElemento.getText();
	}
	
	/**
	 * Obtem o titulo da pagina do driver.
	 * @return
	 */
	public String obtemTituloDaPagina() {
		return driver.getTitle();
	}
	
	public void limparCampo(WebElement elemento) {
		elemento.clear();
	}
	
	
}
