package com.automacaoteste.automacao;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Builder.ProdutoBuilder;
import page.ControleProdutoPO;
import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleProdutoTeste extends BaseTeste{
	
	private static LoginPO loginPO;
	private static ControleProdutoPO controleProdutoPO;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
		controleProdutoPO = new ControleProdutoPO(driver);
		loginPO.executarAcaoDeLogar("admin@admin.com", "admin@123");
	}
	
	
	@Test
	public void UC001_deveAbrirModalParaCadastroAoClicarNoBotaoCriar(){
		controleProdutoPO.clicarBotaoCriar();
		// TODO: Remover esse clique assim que o sistema for corrigido.
		controleProdutoPO.clicarBotaoCriar();
		assertEquals("Produto", controleProdutoPO.obtemTituloModal());
		controleProdutoPO.clicarBotaoSair();
		// TODO: Remover esse clique assim que o sistema for corrigido.
		controleProdutoPO.clicarBotaoSair();
	}
	
	@Test
	public void UC002_NaoDeveCadastrarProdutoComCamposVazios(){
		controleProdutoPO.clicarBotaoCriar();
		controleProdutoPO.cadastrarProduto("1234", "Doug", 5, 12.5, "");
		assertEquals("Produto", controleProdutoPO.obtemTituloModal());
		assertEquals("Todos os campos são obrigatórios para o cadastro!", controleProdutoPO.obtemMensagemErroModal());
		
		controleProdutoPO.clicarBotaoSair();
	}
	
	@Test
	public void UC003_NaoDeveCadastrarProdutoComCamposVazios(){
		controleProdutoPO.clicarBotaoCriar();
		
		// Aqui cria o objeto para adicionar na tela.
		ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPO);
		String mensagem = "Todos os campos são obrigatórios para o cadastro!";
		
		// Aqui realmente ele adiciona as informações na tela.
		produtoBuilder.builder();
		
		// Tentativa de cadastro com campo data Código.
		produtoBuilder
		.adicionarCodigo("")
		.adicionarData("20/05/2020")
		.adicionarNome("Abacaxi")
		.builder();
		
		//controleProdutoPO.cadastrarProduto(produto);
		assertEquals("Produto", controleProdutoPO.obtemTituloModal());
		assertEquals(mensagem, controleProdutoPO.obtemMensagemErroModal());
		
		
		// Tentativa de cadastro com campo data vázio.
		produtoBuilder
		.adicionarData("")
		.adicionarNome("Abacaxi")
		.builder();
		
		//controleProdutoPO.cadastrarProduto(produto);
		assertEquals("Produto", controleProdutoPO.obtemTituloModal());
		assertEquals(mensagem, controleProdutoPO.obtemMensagemErroModal());
		
		// Tentativa de cadastro com campo data vázio.
		produtoBuilder
		.adicionarNome("")
		.builder();
		
		//controleProdutoPO.cadastrarProduto(produto);
		assertEquals("Produto", controleProdutoPO.obtemTituloModal());
		assertEquals(mensagem, controleProdutoPO.obtemMensagemErroModal());
		
		controleProdutoPO.clicarBotaoSair();
	}
}
