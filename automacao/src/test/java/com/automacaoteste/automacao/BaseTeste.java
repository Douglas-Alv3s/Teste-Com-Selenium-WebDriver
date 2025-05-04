package com.automacaoteste.automacao;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class BaseTeste {
	
	protected static WebDriver driver;
    private static final String URL_BASE = "http://127.0.0.1:5500/sistema/login.html";
    private static final String CAMINHO_DRIVER = "C:\\Users\\DouglasAlvesdaSilva\\Documents\\Teste Automátizado\\Curso_Completo\\automacao\\src\\test\\resources\\com\\automacaoteste\\automacao\\msedgedriver-13603240.exe";

    @BeforeClass
    public static void iniciar(){
        System.setProperty("webdriver.edge.driver", CAMINHO_DRIVER);
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
       
    }
    
    @AfterClass
    public static void finalizar() {
    	driver.quit();
    }
}
