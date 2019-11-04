package Temas.IframesAndAjax;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by daniel.gonzali on 30/10/2019.
 */

/*  - MANEJO DE DRAG AND DROP
Hay que tener cuidado de no ir directamente a seleccionar el elemento pues puede que este dentro de un frame
* por ejemplo id=draggable*/
public class HandleFrames {
    public static void main(String [] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");

//        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));    //--> Hay 3 formas de encontrar el frame por un numero, por un string y por web element
        //Si se quisiera buscar por css puede ser iframe.demo-frame ó iframe[class='demo-frame']
        driver.switchTo().frame(0);         //--> si solo hay un iframe, el indice empieza con 0
        driver.findElement(By.id("draggable")).click();

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions a = new Actions(driver);
        a.dragAndDrop(draggable,droppable).build().perform();

        Thread.sleep(5000);
        //Para regresar al iframe padre... se usa defaultContent
        driver.switchTo().defaultContent().findElement(By.linkText("Accept")).click();

    }
}
