package calculator;

import calculator.strCalculator.Calculator;
import calculator.ui.UI;

public class Main {


    public static void main(String[] args) {
        CounterAutomat calc = new Calculator();
        
        try {
            UI uiCal = new UI(calc);
            uiCal.init();
        }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());   
        }
    }
}

