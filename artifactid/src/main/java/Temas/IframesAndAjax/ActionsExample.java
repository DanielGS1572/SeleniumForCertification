package Temas.IframesAndAjax;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by daniel.gonzali on 28/10/2019.
 */
public class ActionsExample {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com/");
        Actions a = new Actions(driver);
        Thread.sleep(5);
        a.click(driver.findElement(By.id("twotabsearchtextbox"))).keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();

        //Right click
        a.moveToElement(driver.findElement(By.cssSelector("span[class='nav-line-2']"))).contextClick().build().perform();
    }
}
