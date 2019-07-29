package TestCases;

import PageObject.RandomMethod;
import Tools.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Tools.Dice;

public class TestCase {

    private WebDriver driver;
    private String _url = "https://www.random.org/dice/?num=1";
    private RandomMethod _randomize;
    private int repeatNum;


    @BeforeTest
    public void Initialize() {
        driver = Helper.InitializeDriver(_url);
        _randomize = new RandomMethod(driver);

    }

    @Test
    public void TestRoll100(){
        repeatNum = 100;
        Dice.randomizeDice(driver,repeatNum);
        System.out.println("############ Test 100 rolls ###############");
        Dice.getTotalOccurrence();
        System.out.println("Deviation is " + Dice.calculateDeviation(repeatNum));
    }

    @Test
    public void TestRoll200(){
        repeatNum = 200;
        Dice.randomizeDice(driver,repeatNum);
        System.out.println("############ Test 200 rolls ###############");
        Dice.getTotalOccurrence();
        System.out.println("Deviation is " + Dice.calculateDeviation(repeatNum));
    }

    @Test
    public void TestRoll500(){
        repeatNum = 500;
        Dice.randomizeDice(driver,repeatNum);
        System.out.println("############ Test 500 rolls ###############");
        Dice.getTotalOccurrence();
        System.out.println("Deviation is " + Dice.calculateDeviation(repeatNum));
    }

    @AfterTest
    public void TearDown(){
        if(driver != null)driver.quit();
    }
}
