package fpptool.algos;

import java.util.HashMap;

public class Input {
    /**
     * Bedarfe
     */
    public final HashMap<Integer, Double> d;

    /**
     * Rüstkostensatz
     */
    public final double K;

    /**
     * Lagerkostensatz
     */
    public final double h;

    /**
     * Fixed Range
     */
    public final int fixedRange;

    /**
     * Fixed Lot
     */
    public final int fixedLot;

    public Input(HashMap<Integer, Double> d, double K, double h, int fixedRange, int fixedLot) {
        this.d = d;
        this.K = K;
        this.h = h;
        this.fixedRange = fixedRange;
        this.fixedLot = fixedLot;
    }

    /**
     * Generate HashMap from String "123;34;234;4234;67"
     *
     * @param bedarfe
     * @return
     */
    public static HashMap<Integer, Double> convertBedarfeFromStringToHashMap(String bedarfe) {
        String[] ds = bedarfe.split(";");
        HashMap<Integer, Double> returnValue = new HashMap<>();
        int i = 1;
        for (String s : ds) {
            returnValue.put(i++, Double.parseDouble(s));
        }
        return returnValue;
    }
}
