package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import org.openqa.selenium.By;

public class NovaContaPage extends BasePage {

    public void setNomeConta(String nome) {
        write("nome", nome);
    }

    public void  salvarConta() {
        click(By.xpath("//button[@type='submit']"));
    }

    public String getMensagemConfirmacao() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-success']"));
        return msg;
    }

    public String getMensagemErro() {
        String msg = getFieldText(By.xpath("//div[@class='alert alert-danger']"));
        return msg;
    }
}
