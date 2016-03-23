package fpptool;
import fpptool.algos.Input;
import fpptool.algos.Output;
import fpptool.algos.impl.SilverMealVerfahren;
import fpptool.algos.impl.StueckkostenVerfahren;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        HashMap d = Input.convertBedarfeFromStringToHashMap("100;90;80;70;160;140;110;150;190;210");
        Input input = new Input(d, 100.0, 0.2, 0, 0);

        StueckkostenVerfahren algo1 = new StueckkostenVerfahren(input);
        Output output1 = algo1.doTheMagic();
        System.out.println(output1.sumCosts().toString() + " GE");

        SilverMealVerfahren algo2 = new SilverMealVerfahren(input);
        Output output2 = algo2.doTheMagic();
        System.out.println(output2.sumCosts().toString() + " GE");


    }
}
