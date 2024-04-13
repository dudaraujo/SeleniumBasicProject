package br.ce.dudaraujo.test;

import br.ce.dudaraujo.core.BaseTest;
import br.ce.dudaraujo.page.MenuPage;
import br.ce.dudaraujo.page.MovimentacaoPage;
import br.ce.dudaraujo.page.ResumoMensalPage;
import br.ce.dudaraujo.utils.DataUtils;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MovimentacaoTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    MovimentacaoPage movimentacaoPage = new MovimentacaoPage();

    ResumoMensalPage resumoMensalPage = new ResumoMensalPage();

    @Test
    public void test1_inserirMovimentacao() {
        menuPage.clickMenuCriarMovimentacao();
        //ovimentacaoPage.selectTipoMovimentacao("Despesa");
        movimentacaoPage.selectDtTransacao(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.selectDtPagamento(DataUtils.obterDataFormatada(new Date()));
        movimentacaoPage.selectDesc("teste da duda");
        movimentacaoPage.selectInteressado("Dudica");
        movimentacaoPage.selectValor("10000");
        movimentacaoPage.selectConta("Conta 1 Editada");
        movimentacaoPage.selectStatus("Pago");
        movimentacaoPage.submit();

        Assert.assertEquals("Movimentação adicionada com sucesso!", movimentacaoPage.getMensagemConfirmacao());

    }

    @Test
    public void teste2_camposObrigatoriosMovimentacao() {
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
    public void teste3_inserirMovimentacaoFutura() {
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
