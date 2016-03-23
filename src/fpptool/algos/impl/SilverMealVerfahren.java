package fpptool.algos.impl;

import fpptool.algos.AbstractAlgo;
import fpptool.algos.Input;

public class SilverMealVerfahren extends AbstractAlgo {


    public SilverMealVerfahren(Input input) {
        super(input);
    }

    @Override
    protected double calcV(Integer tau, Integer t) {
        return calcC(tau, t - 1);
    }

    @Override
    protected double calcC(Integer tau, Integer t) {
        double sum_dj = 0.0;
        for (int j = tau + 1; j <= t; j++) {
            sum_dj += (j - tau) * input.d.get(j);
        }
        return (input.K + input.h * sum_dj) / (t - tau + 1);
    }
}
