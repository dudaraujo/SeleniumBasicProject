package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import org.openqa.selenium.By;

public class AlterarContaPage extends BasePage {



    public void clickContaCriada(String conta) {
        obterCelula("Conta", conta, "Ações", "tabelaContas").findElement(By.xpath(".//span[@class='glyphicon glyphicon-edit']")).click();

    }
    public void editNomeConta(String nome) {
        write("nome", nome);
    }

    public void salvarContaAlterada() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMensagemConfirmacao() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-success']"));
        return msg;
    }
}
