package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.MovimentacaoPage;
import br.ce.dudaraujo.utils.DataUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @Test
    public void camposObrigatoriosMovimentacao() {
        menuPage.clickMenuCriarMovimentacao();
        movimentacaoPage.submit();

        List<String> erros = movimentacaoPage.obterErros();

        Assert.assertTrue(erros.containsAll(Arrays.asList(
                "Data da Movimentação é obrigatório",
                "Data do pagamento é obrigatório",
                "Descrição é obrigatório",
                "Interessado é obrigatório",
                "Valor é obrigatório",
                "Valor deve ser um número"
        )));

        Assert.assertEquals(6, erros.size());
    }

    @Test
    public void inserirMovimentacaoFutura() {
        menuPage.clickMenuCriarMovimentacao();

        Date dataFutura = DataUtils.obterDataComDiferencaDias(5);

        movimentacaoPage.selectDtTransacao(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.selectDtPagamento(DataUtils.obterDataFormatada(dataFutura));
        movimentacaoPage.selectDesc("teste da duda");
        movimentacaoPage.selectInteressado("Dudica");
        movimentacaoPage.selectValor("10000");
        movimentacaoPage.selectConta("Conta 1 Editada");
        movimentacaoPage.selectStatus("Pendente");
        movimentacaoPage.submit();

        Assert.assertEquals("Data da Movimentação deve ser menor ou igual à data atual", movimentacaoPage.getMensagemErro());

    }
}
