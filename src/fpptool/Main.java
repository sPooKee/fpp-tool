package fpptool;
import fpptool.algos.Input;
import fpptool.algos.Output;
import fpptool.algos.impl.StkKostVerfAlgo;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        HashMap d = Input.convertBedarfeFromStringToHashMap("100;90;80;70;160;140;110;150;190;210");
        Input input = new Input(d, 100.0, 0.2, 0, 0);
        StkKostVerfAlgo algo = new StkKostVerfAlgo(input);
        Output output = algo.doTheMagic();

        System.out.println(output.sumCosts().toString() + " GE");

    }
}
