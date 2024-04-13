package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import br.ce.dudaraujo.core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
        click(By.id("status_pago"));
    }

    public void submit() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMensagemConfirmacao() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-success']"));
        return msg;
    }

    public List<String> obterErros() {
        List<WebElement> erros = DriverFactory.getDriver().findElements(By.xpath("//div[@class='alert alert-danger']//li"));
        List<String> retorno = new ArrayList<String>();
        for(WebElement erro: erros) {
            retorno.add(erro.getText());
        }
        return retorno;
    }

    public String getMensagemErro() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-danger']"));
        return msg;
    }
}
