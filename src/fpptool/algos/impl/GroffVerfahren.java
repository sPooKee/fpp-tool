package fpptool.algos.impl;

import fpptool.algos.AbstractVerfahren;
import fpptool.algos.Input;

public class GroffVerfahren extends AbstractVerfahren
{


    public GroffVerfahren(Input input)
    {
        super(input);
    }

    @Override
    protected double calcV(Integer tau, Integer t)
    {
        return 2 * input.K / input.h;
    }

    @Override
    protected double calcC(Integer tau, Integer t)
    {
        int j = t - tau;
        return input.d.get(t) * j * (j + 1);
    }
}
