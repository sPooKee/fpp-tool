package fpptool.algos.impl;

import fpptool.algos.AbstractVerfahren;
import fpptool.algos.Input;

public class DynamischePlanungsrechnungVerfahren extends AbstractVerfahren
{

    public DynamischePlanungsrechnungVerfahren(Input input)
    {
        super(input);
    }

    @Override
    protected double calcV(Integer tau, Integer t)
    {
        return input.K;
    }

    @Override
    protected double calcC(Integer tau, Integer t)
    {
        int j = t - tau;
        return input.d.get(t) * j * input.h;
    }
}
