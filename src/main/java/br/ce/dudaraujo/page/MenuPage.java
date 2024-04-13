package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void clickMenuConta() {
        click(By.className("dropdown-toggle"));
    }

    public void clickSubMenuAdcionar() {
        click(By.xpath("//a[contains (.,'Adicionar')]"));
    }

    public void clickSubMenuListar() {
        click(By.xpath("//a[contains (.,'Listar')]"));
    }

    public void clickMenuCriarMovimentacao() {
        click(By.xpath("//a[contains (.,'Criar Movimentação')]"));
    }

    public void clickMenuResumoMensal() {
        click(By.xpath("//a[contains (.,'Resumo Mensal')]"));
    }

    public String getSaldo(String conta) {
       String saldo = obterCelula("Conta", conta, "Saldo", "tabelaSaldo").getText();
        return saldo;
    }
}
