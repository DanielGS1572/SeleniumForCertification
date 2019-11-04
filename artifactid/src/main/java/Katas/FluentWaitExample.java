package Katas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Function;

/**
 * Created by daniel.gonzali on 1/11/2019.
 */
public class FluentWaitExample {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        Wait<WebDriver> w = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMinutes(5))
                .pollingEvery(Duration.ofMinutes(2));
     /*   w.until(new Function<WebDriver,WebElement>(){

        })*/
    }
}
