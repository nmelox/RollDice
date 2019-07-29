package Tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Helper {

    private static WebDriver driver;

    public static WebDriver InitializeDriver(String _url){
        driver = new FirefoxDriver();
        driver.get(_url);
        driver.manage().window().maximize();
        return driver;
    }

}
