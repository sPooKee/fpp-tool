package fpptool.algos.impl;

import fpptool.algos.AbstractVerfahren;
import fpptool.algos.Input;

public class StueckkostenVerfahren extends AbstractVerfahren
{


    public StueckkostenVerfahren(Input input)
    {
        super(input);
    }

    protected double calcV(Integer tau, Integer t)
    {
        return calcC(tau, t - 1);
    }

    protected double calcC(Integer tau, Integer t)
    {
        double sum_d1 = 0.0;
        double sum_d2 = 0.0;

        for (int j = tau + 1; j <= t; j++) {
            sum_d1 += input.d.get(j) * (j - tau);
        }

        for (int j = tau; j <= t; j++) {
            sum_d2 += input.d.get(j);
        }

        return (input.K + input.h * sum_d1) / sum_d2;
    }

}

