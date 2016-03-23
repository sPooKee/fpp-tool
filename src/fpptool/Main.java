package fpptool;
import fpptool.alogs.Input;
import fpptool.alogs.Output;
import fpptool.alogs.impl.StkKostVerfAlgo;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        HashMap d = generateInputDfromString("100;90;80;70;160;140;110;150;190;210");
        Input input = new Input(d, 100.0, 0.2, 0, 0);
        StkKostVerfAlgo algo = new StkKostVerfAlgo(input);
        Output output = algo.doTheMagic();

        Thread.sleep(1);
    }

    /**
     * @TODO: implement!!
     *
     * @param d
     * @return
     */
    public static HashMap<Integer, Double> generateInputDfromString(String d){
        String[] ds = d.split(";");
        HashMap<Integer, Double> returnValue = new HashMap<>();
        int i = 1;
        for (String s : ds) {
            returnValue.put(i++, Double.parseDouble(s));
        }
        return returnValue;
    }
}
