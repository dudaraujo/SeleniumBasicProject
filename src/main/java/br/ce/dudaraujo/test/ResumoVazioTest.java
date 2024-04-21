package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.core.DriverFactory;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.ResumoMensalPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResumoVazioTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    ResumoMensalPage resumoMensalPage = new ResumoMensalPage();

    @Test
    public void testeResumoMensalVazio() {

        menuPage.clickMenuResumoMensal();
        resumoMensalPage.clickAno("2010");
        resumoMensalPage.clickSubmit();

       List<WebElement> elementosEncontrados =  DriverFactory.getDriver().findElements(By.xpath("//table[@id='tabelaExtrato']//tbody//tr"));

       Assert.assertEquals(0, elementosEncontrados.size());
    /*    try {
            DriverFactory.getDriver().findElement(By.xpath("//table[@id='tabelaExtrato']//tbody//tr"));
            Assert.fail();
        } catch (NoSuchElementException e) {

        }*/






    }

}
