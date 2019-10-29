package Temas.Synchronization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.function.Function;

/**
 * Created by daniel.gonzali on 28/10/2019.
 */
public class FluentWaitExample {

    /* FluentWait y WebDriverWait usan la interface Wait (la cual provee el concepto de explicit wait)
    * */

    //http://the-internet.herokuapp.com/dynamic_loading
    public static void main(String args[]){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.cssSelector("[id='start'] button"));
        startButton.click();

        //En fluentwait no se tiene el expected conditions de implicit wait por lo que se tiene que definir a traves de una nueva funcion
        //en la que recibe como parametro un WebDriver y regresa un WebElement
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))/*.ignoring(NoSuchElementException.class)*/;

        wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                //Con este if de alguna manera se esta haciendo el expected condition
                if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    System.out.println("FOUND");
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                }else{
                    System.out.println("NOT FOUND");
                    return null;
                }
            }
        });

        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
    }

}
