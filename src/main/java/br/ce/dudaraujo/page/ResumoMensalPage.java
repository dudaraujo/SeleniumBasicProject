package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import org.openqa.selenium.By;

public class ResumoMensalPage extends BasePage {

    public void clickMovimentacao(String conta) {
        obterCelula("Conta", conta, "Ações", "tabelaExtrato").findElement(By.xpath(".//span[@class='glyphicon glyphicon-remove-circle']")).click();

    }


    public String getMensagemConfirmacao() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-success']"));
        return msg;
    }

    public void clickAno(String ano) {
        selectCombo("ano", ano);
    }

    public void clickSubmit() {
        click(By.xpath("//input[@value='Buscar']"));
    }

}
