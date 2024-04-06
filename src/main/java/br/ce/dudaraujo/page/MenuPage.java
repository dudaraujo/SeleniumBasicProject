package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import org.openqa.selenium.By;

public class MenuPage extends BasePage {

    public void clickMenuConta() {
        click(By.className("dropdown-toggle"));
    }

    public void clicSubMenuAdcionar() {
        click(By.xpath("//a[contains (.,'Adicionar')]"));
    }
}
