package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;

public class RandomElement {
    private By _roll;
    private By _dice;
    private By _dice2;
    private WebDriver driver;

    public RandomElement(WebDriver driver){
        this.driver = driver;
        _roll = By.xpath("/html/body/div/form/input[2]");
        _dice = By.xpath("/html/body/div/p[3]/img");
    }

    public WebElement rollbtn() {return driver.findElement(_roll);}
    public WebElement diceElement () {return driver.findElement(_dice);}
}
