package PageObject;

import org.openqa.selenium.WebDriver;

public class RandomMethod extends RandomElement {

    private RandomElement _randomElement;

    public RandomMethod(WebDriver driver) {
        super(driver);
        this._randomElement = new RandomElement(driver);
    }

    public void clickRollbtn (){
        this._randomElement.rollbtn().click();
    }

    public String getDiceNumber(){
        return this._randomElement.diceElement().getAttribute("alt");
    }
}
