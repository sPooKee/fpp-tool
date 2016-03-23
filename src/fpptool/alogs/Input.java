package fpptool.alogs;

import java.util.HashMap;
import java.util.List;

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

    public Input(HashMap<Integer, Double> d, double k, double h, int fixedRange, int fixedLot) {
        this.d = d;
        K = k;
        this.h = h;
        this.fixedRange = fixedRange;
        this.fixedLot = fixedLot;
    }
}
