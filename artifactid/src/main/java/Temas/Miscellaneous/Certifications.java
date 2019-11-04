package Temas.Miscellaneous;

import com.sun.glass.ui.View;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;

/**
 * Created by daniel.gonzali on 3/11/2019.
 */
public class Certifications {
    //para poder aceptar urls que no tengan certificados ssl o que sean inseguras
    //se debe de manejar desiredCapabilities
    public static void main(String[] args) throws IOException {
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);

        ChromeOptions option = new ChromeOptions();
        option.merge(dc);

        System.setProperty("","");
        WebDriver driver = new ChromeDriver(option);

        //Para poder borrar las cookies se usa manage
        driver.manage().deleteAllCookies();


        //para sacar un screenshot...
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\daniel.gonzali\\screenshot.png"));
    }
}
