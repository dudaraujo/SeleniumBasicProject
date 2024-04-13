package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.core.DriverFactory;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.ResumoMensalPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ResumoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    ResumoMensalPage resumoMensalPage = new ResumoMensalPage();

    @Test
    public void teste1_removerMovimentacao() {
        menuPage.clickMenuResumoMensal();
        resumoMensalPage.clickMovimentacao("Conta 1 Editada");

        Assert.assertEquals("Movimentação removida com sucesso!", resumoMensalPage.getMensagemConfirmacao());
    }
    @Test
    public void teste2_resumoTest() {
        menuPage.clickMenuResumoMensal();

        Assert.assertEquals("Seu Barriga - Extrato", DriverFactory.getDriver().getTitle());
    }


}
