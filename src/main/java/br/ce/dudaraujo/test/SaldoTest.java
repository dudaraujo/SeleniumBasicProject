package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.MenuPage;
import org.junit.Assert;
import org.junit.Test;

public class SaldoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @Test
    public void testeverificaSaldoConta() {
        String saldo = menuPage.getSaldo("Conta 1 Editada");

        Assert.assertEquals("10000.00", saldo);

    }
}
