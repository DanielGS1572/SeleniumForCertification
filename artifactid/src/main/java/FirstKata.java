import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class FirstKata {
    /* public static void main (String [] args){
         WebDriverManager.chromedriver().setup();
         WebDriver driver = new ChromeDriver();
         driver.get("http://www.google.com");
     }*/
    public static void main(String[] args) throws InterruptedException {
/**
 * HAY 4 FORMAS DE SINCRONIZACIÓN
 *  - Implicit wait
 *  - Explicit wait
 *  - Thread.sleep
 *  - Fluent wait
 */

      //  System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");    //SETUP OF WEBDRIVER


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//implicitWait es de forma general y aplica a cada findElement... No puede ser un numero muy alto
        //pues se pueden esconder temas de performance y no puede ser tan bajo como para que no tome
        //los elementos
//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //explicitWait es para cuando el implicitWait no es suficientes

        WebDriverWait w = new WebDriverWait(driver, 5);


        String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot"};


        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        Thread.sleep(3000);

        addItems(driver, itemsNeeded);

        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));


        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        driver.findElement(By.cssSelector("button.promoBtn")).click();

//explicit wait


        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());


    }

    public static void addItems(WebDriver driver, String[] itemsNeeded) {

        int j = 0;

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {

//Brocolli - 1 Kg

//Brocolli,    1 kg

            String[] name = products.get(i).getText().split("-");

            String formattedName = name[0].trim();

//format it to get actual vegetable name

//convert array into array list for easy search

//  check whether name you extracted is present in arrayList or not-

            List itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {

                j++;

//click on Add to cart

                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if (j == itemsNeeded.length) {

                    break;

                }

            }

        }

    }


}