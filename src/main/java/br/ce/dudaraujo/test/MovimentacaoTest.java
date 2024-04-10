package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.MovimentacaoPage;
import org.junit.Assert;
import org.junit.Test;

public class MovimentacaoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    @Test
    public void inserirMovimentacao() {
        menuPage.clickMenuCriarMovimentacao();
        movimentacaoPage.selectTipoMovimentacao("Despesa");
        movimentacaoPage.selectDtTransacao("09/04/2024");
        movimentacaoPage.selectDtPagamento("09/04/2024");
        movimentacaoPage.selectDesc("teste da duda");
        movimentacaoPage.selectInteressado("Dudica");
        movimentacaoPage.selectValor("10000");
        movimentacaoPage.selectConta("Conta 1 Editada");
        movimentacaoPage.selectStatus("Pago");
        movimentacaoPage.submit();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.getMensagemConfirmacao());

    }
}
