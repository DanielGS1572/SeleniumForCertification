package Temas.IframesAndAjax;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by daniel.gonzali on 29/10/2019.
 */
public class MultipleWindows {
    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://accounts.google/signup");
        driver.findElement((By.xpath(""))).click();

        System.out.println(driver.getTitle());
        Set<String> ids = driver.getWindowHandles();
        Iterator<String> it = ids.iterator();

        /*String parentId = */it.next();
        String childId = it.next();

        driver.switchTo().window(childId);
        System.out.println(driver.getTitle());
    }
}
