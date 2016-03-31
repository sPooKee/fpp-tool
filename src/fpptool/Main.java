package fpptool;

import fpptool.algos.Input;
import fpptool.algos.Output;
import fpptool.algos.impl.*;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        /*HashMap d = Input.convertBedarfeFromStringToHashMap("100;90;80;70;160;140;110;150;190;210");


        for (double K = 10; K <= 100; K += 10) {
            for (double h = 0.1; h <= 1; h += 0.1) {
                Input input = new Input(d, K, h, 0, 0);
                calcAlgos(input);
            }
        }*/

        HashMap d = Input.convertBedarfeFromStringToHashMap("15;5;20;25");
        Input input = new Input(d, 150, 5, 0, 0);
        calcWagnerWhitin(input);
    }

    private static void calcWagnerWhitin(Input input) {
        System.out.println("Input: " + input.K + " - " + input.h);
        WagnerWithin algo = new WagnerWithin(input);
        algo.doTheMagic();
    }

    public static void calcAlgos(Input input) {
        System.out.println("Input: " + input.K + " - " + input.h);

        StueckkostenVerfahren algo1 = new StueckkostenVerfahren(input);
        Output output1 = algo1.doTheMagic();
        System.out.println(output1.algoName + ": \t\t\t\t" + output1.sumCosts().toString() + " GE - " + output1.getRuntime());

        SilverMealVerfahren algo2 = new SilverMealVerfahren(input);
        Output output2 = algo2.doTheMagic();
        System.out.println(output2.algoName + ": \t\t\t\t\t" + output2.sumCosts().toString() + " GE - " + output2.getRuntime());

        StueckperiodenausgleichsVerfahren algo3 = new StueckperiodenausgleichsVerfahren(input);
        Output output3 = algo3.doTheMagic();
        System.out.println(output3.algoName + ": \t" + output3.sumCosts().toString() + " GE - " + output3.getRuntime());

        GroffVerfahren algo4 = new GroffVerfahren(input);
        Output output4 = algo4.doTheMagic();
        System.out.println(output4.algoName + ": \t\t\t\t\t\t" + output4.sumCosts().toString() + " GE - " + output4.getRuntime());

        DynamischePlanungsrechnungVerfahren algo5 = new DynamischePlanungsrechnungVerfahren(input);
        Output output5 = algo5.doTheMagic();
        System.out.println(output5.algoName + ": \t" + output5.sumCosts().toString() + " GE - " + output5.getRuntime());

        System.out.println(" - - - - - - - - - - - - - - - - - - - - - ");
    }

}
