package Tools;

import PageObject.RandomMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.lang.Math;

public class Dice {

    private static int [] dice = {0,0,0,0,0,0};
    private static RandomMethod _randomize ;
    private static WebDriverWait wait;


    public static int getDice(int i) {return dice [i];}

    public static void addOccurrence(String value){
        // I tried to use a Switch but I dont know why Switch doesnt allow String value on condition.
        if (value.equals("1")) { dice [0] += 1;}
        else if (value.equals("2")) {dice [1] += 1;}
        else if (value.equals("3")) {dice [2] += 1;}
        else if (value.equals("4")) {dice [3] += 1;}
        else if (value.equals("5")) {dice [4] += 1;}
        else if (value.equals("6")) {dice [5] += 1;}
    }

    public static void randomizeDice(WebDriver driver, int repeatNumber){
        String value;
        Dice _dice = new Dice();
        _randomize = new RandomMethod(driver);
        wait = new WebDriverWait(driver, 20);
        for(int i = 0; i < repeatNumber; i ++){
            value = _randomize.getDiceNumber();
            wait.until(ExpectedConditions.visibilityOf(_randomize.diceElement()));
            _dice.addOccurrence(value);
            _randomize.clickRollbtn();
        }
    }

    public static void getTotalOccurrence(){
        int _numberDice = 1;
        for(int i=0; i<6; i++){
            System.out.println("Dice " + _numberDice + ": " + Dice.getDice(i));
            _numberDice +=1;
        }
    }

    public static float calculateDeviation(int repeatNumber){
        float _varSD = 0;
        for (int i : dice) {
            _varSD += ((i - (repeatNumber / dice.length)) * (i - (repeatNumber / dice.length))) / dice.length;
        }
        float standardDeviation = (float) Math.sqrt(_varSD);
        return standardDeviation;
    }
}
