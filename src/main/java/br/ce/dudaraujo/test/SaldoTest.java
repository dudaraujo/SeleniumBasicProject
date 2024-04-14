package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

import static br.ce.dudaraujo.core.Properties.NOME_CONTA_ALTERADA;

public class SaldoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @Test
    public void testeverificaSaldoConta() {

        menuPage.clickMenuHome();
        String saldo = menuPage.getSaldo(NOME_CONTA_ALTERADA);

        Assert.assertEquals("10000.00", saldo);

    }
}
