package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.AlterarContaPage;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.NovaContaPage;
import org.junit.Assert;
import org.junit.Test;

import static br.ce.dudaraujo.core.Properties.NOME_CONTA_ALTERADA;

public class RemoverConta extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private NovaContaPage novaContaPage = new NovaContaPage();

    private AlterarContaPage alterarContaPage = new AlterarContaPage();

    @Test
    public void removerContaComMovimentacao() {
        menuPage.clickMenuConta();
        menuPage.clickSubMenuListar();
        alterarContaPage.excluirConta(NOME_CONTA_ALTERADA);

        Assert.assertEquals("Conta em uso na movimentações", novaContaPage.getMensagemErro());

    }



}
