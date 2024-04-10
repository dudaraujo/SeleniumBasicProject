package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import org.openqa.selenium.By;

public class MovimentacaoPage extends BasePage {

    public void selectTipoMovimentacao(String tipo) {
        selectCombo("tipo", tipo);
    }

    public void selectDtTransacao(String dataTransacao) {
        write("data_transacao", dataTransacao);

    }

    public void selectDtPagamento(String dataPagamento) {
        write("data_pagamento", dataPagamento);
    }

    public void selectDesc(String desc) {
        write("descricao", desc);
    }

    public void selectInteressado(String interessado) {
        write("interessado", interessado);
    }

    public void selectValor(String valor) {
        write("valor", valor);
    }

    public void selectConta(String conta) {
        selectCombo("conta", conta);
    }

    public void selectStatus(String status) {
        click(By.id("status_pendente"));
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMensagemConfirmacao() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-success']"));
        return msg;
    }
}
