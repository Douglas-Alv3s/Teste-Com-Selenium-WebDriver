package com.automacaoteste.automacao;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTeste extends BaseTeste{

	private static LoginPO loginPO;
	
	@BeforeClass
	public static void prepararTeste() {
		loginPO = new LoginPO(driver);
	}
	
	@Test
	public void UC01_NaoLogarSistemaSenhaEmailVazio() {
		loginPO.executarAcaoDeLogar("", "");		
		assertEquals(loginPO.obtemMensagemErro(), "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void UC02_NaoLogarSistemaComEmailInvalidoSenhaVazia() {
		loginPO.executarAcaoDeLogar("teste", "");
		assertEquals(loginPO.obtemMensagemErro(), "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void UC03_NaoLogarSistemaComSenhaInvalidoEmailVazio() {
		loginPO.executarAcaoDeLogar("", "teste");
		assertEquals(loginPO.obtemMensagemErro(), "Informe usuário e senha, os campos não podem ser brancos.");
	}
	
	@Test
	public void UC04_NaoLogarSistemaComEmailSenhaInvalidos() {
		loginPO.executarAcaoDeLogar("teste", "teste");
		assertEquals(loginPO.obtemMensagemErro(), "E-mail ou senha inválidos");
	}
	
	@Test
	public void UC05_NaoLogarSistemaComEmailValidoESenhaInvalida() {
		loginPO.executarAcaoDeLogar("admin@admin.com", "teste");
		assertEquals(loginPO.obtemMensagemErro(), "E-mail ou senha inválidos");
	}
	
	@Test
	public void UC06_NaoLogarSistemaComEmailInvalidoESenhaValida() {
		loginPO.executarAcaoDeLogar("teste", "admin@123");
		assertEquals(loginPO.obtemMensagemErro(), "E-mail ou senha inválidos");
	}
	
	@Test
	public void UC07_LogarSistemaComEmailESenhaValidos() {
		loginPO.executarAcaoDeLogar("admin@admin.com", "admin@123");
		assertEquals(loginPO.obtemTituloDaPagina(), "Controle de Produtos");
	}
}
