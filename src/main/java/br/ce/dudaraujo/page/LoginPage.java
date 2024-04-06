package br.ce.dudaraujo.page;

import br.ce.dudaraujo.core.BasePage;
import br.ce.dudaraujo.core.DriverFactory;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    public void acessarTelaInicial() {
        DriverFactory.getDriver().get("https://seubarriga.wcaquino.me");
    }

    public void setEmail(String email) {
        write("email", email);
    }

    public void setSenha(String senha) {
        write("senha", senha);
    }

    public void enter() {
        click(By.xpath("//button[@type='submit']"));
    }




}
