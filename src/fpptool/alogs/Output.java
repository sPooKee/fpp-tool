package fpptool.alogs;

import java.util.HashMap;
import java.util.Map;

public class Output {

    /**
     * Name des verwendeten Algorithmus
     */
    public final String algoName;

    /**
     * Lots
     */
    public HashMap<Integer, Lot> lots = new HashMap<>();

    /**
     * Gesamtkosten
     */
    public double sumCosts;

    /**
     * Eingangs Parameter
     */
    public final Input input;

    public Output(String algoName, Input input) {
        this.algoName = algoName;
        this.input = input;
    }
}
