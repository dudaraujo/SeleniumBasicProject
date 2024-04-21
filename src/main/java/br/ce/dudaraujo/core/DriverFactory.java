package br.ce.dudaraujo.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class DriverFactory {

    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>(){
        @Override
        protected synchronized  WebDriver initialValue() {
            return initDriver();
        }
    };

    //private static WebDriver driver;
    private DriverFactory() {}

    public static WebDriver getDriver() {
        return  threadDriver.get();
    }

    public static WebDriver initDriver() {
       WebDriver driver = null;
            //switch(Properties.browser) {
            //case FIREFOX: driver = new FirefoxDriver();
            //break;

            //case CHROME: driver = new ChromeDriver();
            //break;
            //}*/
            System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
            //driver.manage().window().setSize(new Dimension(1200, 75));

        return driver;
    }

    public static void killDriver() {
        WebDriver driver = getDriver();
        if(driver != null) {
            driver.quit();
            driver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }


    }
}
