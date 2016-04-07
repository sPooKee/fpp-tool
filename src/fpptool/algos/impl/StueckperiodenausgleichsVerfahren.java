package fpptool.algos.impl;

import fpptool.algos.AbstractVerfahren;
import fpptool.algos.Input;


public class StueckperiodenausgleichsVerfahren extends AbstractVerfahren
{

    @Override
    public String getName()
    {
        return "Stückperiodenausgleich";
    }

    public StueckperiodenausgleichsVerfahren(Input input)
    {
        super(input);
    }

    @Override
    protected double calcV(Integer tau, Integer t)
    {
        /**
         * Quotient aus Rüst- und Lagerkosten
         */
        return input.K / input.h;
    }

    @Override
    protected double calcC(Integer tau, Integer t)
    {
        double sum_dj = 0;
        for (int j = tau + 1; j <= t; j++) {
            sum_dj += (j - tau) * input.d.get(j);
        }
        return sum_dj;
    }
}
