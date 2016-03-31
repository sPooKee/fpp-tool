package fpptool.algos;

import java.util.HashMap;
import java.util.Map;

public class Output {

    public Output(String algoName, Input input) {
        this.algoName = algoName;
        this.input = input;
    }

    /**
     * Name des verwendeten Algorithmus
     */
    public final String algoName;
    /**
     * Eingangs Parameter
     */
    public final Input input;
    /**
     * Lots
     */
    public HashMap<Integer, Lot> lots = new HashMap<>();

    /**
     * Gesamtkosten
     */
    public Double sumCosts = null;

    private Long runtime = null;

    public Double sumCosts() {
        if (null == sumCosts) {
            sumCosts = 0.0;
            for (Map.Entry<Integer, Lot> entry : lots.entrySet()) {
                sumCosts += entry.getValue().sumCosts();
            }
        }
        return sumCosts;
    }

    public Long getRuntime() {
        return runtime;
    }

    public void setRuntime(Long runtime) {
        if (null == this.runtime && null != runtime)
            this.runtime = runtime;
    }
}
