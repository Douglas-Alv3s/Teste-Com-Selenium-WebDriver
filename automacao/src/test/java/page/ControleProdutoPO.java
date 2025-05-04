package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ControleProdutoPO extends BasePO{

	@FindBy(id="btn-adicionar")
	private WebElement btnAdicionar;
	
	@FindBy(css = "ul>li>a.nav-link")
	private WebElement linkVoltar;
	
	@FindBy(css = "div.modal-header>h4.modal-title")
	private WebElement tituloModalCriacao;
	
	@FindBy(id = "codigo")
	private WebElement modalCodigo;

	@FindBy(id = "nome")
	private WebElement modalNome;

	@FindBy(id = "quantidade")
	private WebElement modalQuantidade;
	
	@FindBy(id = "valor")
	private WebElement modalValor;

	@FindBy(id = "data")
	private WebElement modalData;
	
	@FindBy(id = "btn-salvar")
	private WebElement btnSalvar;

	@FindBy(id = "btn-sair")
	private WebElement btnSair;
	
	@FindBy(id = "mensagem")
	private WebElement modalMensagem;

	/**
	 * Construtor do page object de Controle de Produto.
	 * @param driver
	 */
	public ControleProdutoPO(WebDriver driver) {
		super(driver);
	}
	
	/*
	 * Clica no botão Criar da pagina Controle de Produto.
	 */
	public void clicarBotaoCriar() {
		clicarBotao(btnAdicionar);
	}

	/*
	 * Obtem o titulo presente no modal da pagina Controle de Produto.
	 */
	public String obtemTituloModal() {
		return obtemTexto(tituloModalCriacao);
	}
	
	/*
	 * Obtem a mensagem de erro do modal na pagina Controle de Produto.
	 */
	public String obtemMensagemErroModal() {
		return obtemTexto(modalMensagem);
	}
		
	/*
	 * Clica no botão "Salvar" do modal na pagina Controle de Produto.
	 */
	public void clicarBotaoSalvar() {
		clicarBotao(btnSalvar);
	}
	
	/*
	 * Clica no botão "Sair" do modal na pagina Controle de Produto.
	 */
	public void clicarBotaoSair() {
		clicarBotao(btnSair);
	}
	
	/*
	 * Escreve no campo código do modal na pagina Controle de Produto.
	 */
	public void escreverCodigo(String codigo) {
		escrever(modalCodigo, codigo);
	}
	
	/*
	 * Escreve no campo nome do modal na pagina Controle de Produto.
	 */
	public void escreverNome(String nome) {
		escrever(modalNome, nome);
	}
	
	/*
	 * Escreve no campo quantidade do modal na pagina Controle de Produto.
	 */
	public void escreverQuantidade(String quantidade) {
		escrever(modalQuantidade, quantidade);
	}
	
	/*
	 * Escreve no campo valor do modal na pagina Controle de Produto.
	 */
	public void escreverValor(String valor) {
		escrever(modalValor, valor);
	}
	
	/*
	 * Escreve no campo data do modal na pagina Controle de Produto.
	 */
	public void escreverData(String data) {
		escrever(modalData, data);
	}
	
	/**
	 * Realiza o preenchimento dos campos necessários para o cadastro de produto com os parametros passados no método.
	 * @param codigo
	 * @param nome
	 * @param quantidade
	 * @param valor
	 * @param data
	 */
	public void cadastrarProduto(String codigo, String nome, Integer quantidade, Double valor, String data) {
				
		escreverCodigo(codigo);
		escreverNome(nome);
		escreverQuantidade(quantidade.toString());
		escreverValor(valor.toString());
		escreverData(data);
		
		clicarBotaoSalvar();
	}
	
	
	/* Método comentado devido a mudança na forma de utilização da classe ProdutoBuilder.
	public void cadastrarProduto(ProdutoBuilder produtoBuilder) {
		
		escreverCodigo(produtoBuilder.codigo);
		escreverNome(produtoBuilder.nome);
		escreverQuantidade(produtoBuilder.quantidade.toString());
		escreverValor(produtoBuilder.valor.toString());
		escreverData(produtoBuilder.data);
		
		clicarBotaoSalvar();
	}
	*/
}
