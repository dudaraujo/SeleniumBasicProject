package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.NovaContaPage;
import org.junit.Assert;
import org.junit.Test;

public class ContaTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private NovaContaPage novaContaPage = new NovaContaPage();

    @Test
    public void inserirConta() {

        menuPage.clickMenuConta();
        menuPage.clicSubMenuAdcionar();
        novaContaPage.setNomeConta("Conta2");
        novaContaPage.salvarConta();

        Assert.assertEquals("Conta adicionada com sucesso!", novaContaPage.getMensagemConfirmacao());





}

}
