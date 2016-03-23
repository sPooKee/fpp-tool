package fpptool;
import fpptool.algos.Input;
import fpptool.algos.Output;
import fpptool.algos.impl.GroffVerfahren;
import fpptool.algos.impl.SilverMealVerfahren;
import fpptool.algos.impl.StueckkostenVerfahren;
import fpptool.algos.impl.StueckperiodenausgleichsVerfahren;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        HashMap d = Input.convertBedarfeFromStringToHashMap("100;90;80;70;160;140;110;150;190;210");
        Input input = new Input(d, 100.0, 0.2, 0, 0);

        StueckkostenVerfahren algo1 = new StueckkostenVerfahren(input);
        Output output1 = algo1.doTheMagic();
        System.out.println(output1.algoName + ": " + output1.sumCosts().toString() + " GE");

        SilverMealVerfahren algo2 = new SilverMealVerfahren(input);
        Output output2 = algo2.doTheMagic();
        System.out.println(output2.algoName + ": " + output2.sumCosts().toString() + " GE");

        StueckperiodenausgleichsVerfahren algo3 = new StueckperiodenausgleichsVerfahren(input);
        Output output3 = algo3.doTheMagic();
        System.out.println(output3.algoName + ": " + output3.sumCosts().toString() + " GE");

        GroffVerfahren algo4 = new GroffVerfahren(input);
        Output output4 = algo4.doTheMagic();
        System.out.println(output4.algoName + ": " + output4.sumCosts().toString() + " GE");
    }
}
