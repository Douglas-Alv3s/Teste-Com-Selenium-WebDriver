package Builder;

import page.ControleProdutoPO;

/**
 * Classe que sabe construir ou adicionar um produto na tela.
 */
public class ProdutoBuilder {

	private String codigo = "0001";
	private String nome = "Produto Padrão";
	private Integer quantidade = 1;
	private Double valor = 1.0;
	private String data = "04/05/2025";
	
	private ControleProdutoPO controleProdutoPO;
	
	/**
	 * Construtor do ProdutoBuilder que recebe a pagina de controle de produto.
	 * @param controleProdutoPO
	 */
	public ProdutoBuilder(ControleProdutoPO controleProdutoPO) {
		this.controleProdutoPO = controleProdutoPO;
	}
	
	/**
	 * Metodo que sabe adicionar um código ao builder.
	 * @param codigo Código que será adicionado.
	 * @return Retorna a própria classe ProdutoBuilder.
	 */
	public ProdutoBuilder adicionarCodigo(String codigo) {
		this.codigo = codigo;
		return this;	
	}
	
	/**
	 * Metodo que sabe adicionar um nome ao builder.
	 * @param nome Nome que será adicionado.
	 * @return Retorna a própria classe ProdutoBuilder.
	 */
	public ProdutoBuilder adicionarNome(String nome) {
		this.nome = nome;
		return this;	
	}
	
	/**
	 * Metodo que sabe adicionar uma quantidade ao builder.
	 * @param quantidade Quantidade que será adicionado.
	 * @return Retorna a própria classe ProdutoBuilder.
	 */
	public ProdutoBuilder adicionarQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
		return this;	
	}
	
	/**
	 * Metodo que sabe adicionar um valor ao builder.
	 * @param valor Valor que será adicionado.
	 * @return Retorna a própria classe ProdutoBuilder.
	 */
	public ProdutoBuilder adicionarValor(Double valor) {
		this.valor = valor;
		return this;	
	}
	
	/**
	 * Metodo que sabe adicionar uma data ao builder.
	 * @param data Data que será adicionado.
	 * @return Retorna a própria classe ProdutoBuilder.
	 */
	public ProdutoBuilder adicionarData(String data) {
		this.data = data;
		return this;	
	}
	
	
	/**
	 * Método que controi o produto, ou seja, adiciona o produto pela tela de cadastro de produto.
	 */
	public void builder() {
		controleProdutoPO.escreverCodigo(codigo);
		controleProdutoPO.escreverNome(nome);
		controleProdutoPO.escreverQuantidade((quantidade != null) ? quantidade.toString() : "");
		controleProdutoPO.escreverValor((valor != null) ? valor.toString() : "");
		controleProdutoPO.escreverData(data);
		
		controleProdutoPO.clicarBotaoSalvar();
	}
}
