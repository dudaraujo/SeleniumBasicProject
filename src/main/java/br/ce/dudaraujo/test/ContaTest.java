package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.AlterarContaPage;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.NovaContaPage;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static br.ce.dudaraujo.core.Properties.NOME_CONTA_ALTERADA;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ContaTest extends BaseTest {

    private MenuPage menuPage = new MenuPage();
    private NovaContaPage novaContaPage = new NovaContaPage();

    private AlterarContaPage alterarContaPage = new AlterarContaPage();

    @Test
    public void teste1_inserirConta() {

        menuPage.clickMenuConta();
        menuPage.clickSubMenuAdcionar();
        novaContaPage.setNomeConta("Conta1");
        novaContaPage.salvarConta();

        Assert.assertEquals("Conta adicionada com sucesso!", novaContaPage.getMensagemConfirmacao());


}

    @Test
    public void teste2_alterarConta() {
        menuPage.clickMenuConta();
        menuPage.clickSubMenuListar();
        alterarContaPage.clickContaCriada("Conta para alterar");
        alterarContaPage.editNomeConta("Conta Alterada");
        //alterarContaPage.editNomeConta(NOME_CONTA_ALTERADA);
        alterarContaPage.salvarContaAlterada();

        Assert.assertEquals("Conta alterada com sucesso!", alterarContaPage.getMensagemConfirmacao());
    }

    @Test
    public void teste3_criarContaMesmoNome() {
        menuPage.clickMenuConta();
        menuPage.clickSubMenuAdcionar();
        novaContaPage.setNomeConta("Conta mesmo nome");
        novaContaPage.salvarConta();

        Assert.assertEquals("Já existe uma conta com esse nome!", novaContaPage.getMensagemErro());
    }



}
