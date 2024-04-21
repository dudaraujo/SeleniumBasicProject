package br.ce.dudaraujo.core;

import br.ce.dudaraujo.page.LoginPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import static br.ce.dudaraujo.core.DriverFactory.killDriver;

public class BaseTest {

    private LoginPage loginPage = new LoginPage();

    @Before
    public void inicializa() {
        loginPage.acessarTelaInicial();
        loginPage.setEmail("mduda_araujo@teste.com");
        loginPage.setSenha("dudinha");
        loginPage.enter();

    }

    @After
    public void finaliza() {
        DriverFactory.killDriver();
    }

    //@Rule
    //public TestName testName = new TestName();




    @After
    public void quit() {
        //TakesScreenshot ss = (TakesScreenshot) getDriver();
        //File arquivo = ss.getScreenshotAs(OutputType.FILE);
        //FileUtils.copyFile(arquivo, new File("target" + File.separator + "screenshot" + File.separator + testName.getMethodName() + ".jpg"));
        if(Properties.CLOSE_BROWSER) {
            killDriver();
        }
    }
}
