package fpptool.algos;

import java.util.HashMap;
import java.util.Map;

public class Output
{

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

    public Long getRuntime()
    {
        return runtime;
    }

    /**
     * Gesamtkosten
     */

    public Double sumCosts = null;

    public void setRuntime(Long runtime)
    {
        if (null == this.runtime && null != runtime)
            this.runtime = runtime;
    }

    private Long runtime = null;

    public Output(String algoName, Input input)
    {
        this.algoName = algoName;
        this.input = input;
    }

    public Double sumCosts()
    {
        if (null == sumCosts) {
            sumCosts = 0.0;
            for (Map.Entry<Integer, Lot> entry : lots.entrySet()) {
                sumCosts += entry.getValue().sumCosts();
            }
        }
        return sumCosts;
    }
}
