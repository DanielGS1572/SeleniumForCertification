package Temas.IframesAndAjax;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by daniel.gonzali on 3/11/2019.
 */
public class HiddenText {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://ksrtc.in");
        driver.findElement(By.id("fromPlaceName")).sendKeys("BANG");
        Thread.sleep(3000);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
        driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.DOWN);
//Aqui no obtiene el nombre como tal pues esta oculto por lo que se usa javascript con document
        System.out.println( driver.findElement(By.id("fromPlaceName")).getText());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.getElementById(\"fromPlaceName\").value";
        String textRetrieved = (String)js.executeScript(script);
        System.out.println(textRetrieved);
    }
}
