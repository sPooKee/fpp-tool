package fpptool.algos.impl;

import fpptool.algos.AbstractVerfahren;
import fpptool.algos.Input;
import fpptool.algos.Lot;
import fpptool.algos.Output;

import java.util.ArrayList;
import java.util.HashMap;

public class WagnerWithinVerfahren extends AbstractVerfahren
{
    @Override
    public String getName()
    {
        return "Wagner-Within";
    }

    public WagnerWithinVerfahren(Input input)
    {
        super(input);
    }

    @Override
    public Output doTheMagic()
    {
        final long timeStart = System.nanoTime();
        Integer tau = 1;
        Integer T = input.d.size();

        Output output = new Output(getClass().toString(), input);

        HashMap<Integer, Double> C = new HashMap<Integer, Double>();
        Double C_Star = null;
        HashMap<Integer, Integer> j = new HashMap<>();

        for (int t = tau + 1; t <= T + 1; t++) {
            C.put(t, calcC(tau, t));
            j.put(t, 1);
        }

        for (tau = tau + 1; tau < T; tau++) {
            for (int t = tau + 1; t <= T + 1; t++) {
                C_Star = C.get(tau) + calcC(tau, t);
                if (C_Star < C.get(t)) {
                    C.put(t, C_Star);
                    j.put(t, tau);
                }
            }
        }

        ArrayList<Integer> optimalerWeg = new ArrayList<Integer>();
        for (int i = T + 1; i > 1; i = j.get(i)) {
            optimalerWeg.add(0, i);
        }
        optimalerWeg.add(0, 1); //j_0 = 1

        for (int t = 0; t <= (optimalerWeg.size() - 2); t++) {
            int q = 0;
            for (int i = optimalerWeg.get(t); i <= (optimalerWeg.get(t + 1) - 1); i++) {
                q += input.d.get(i);
            }
            output.lots.put(optimalerWeg.get(t), new Lot(q, optimalerWeg.get(t), input.K, calcC(optimalerWeg.get(t), optimalerWeg.get(t + 1)) - input.K));
        }

        output.setRuntime(System.nanoTime() - timeStart);
        return output;
    }

    @Override
    protected double calcV(Integer tau, Integer t)
    {
        //Wird  für dieses Verfahren nicht benötigt...
        return 0;
    }

    @Override
    protected double calcC(Integer tau, Integer t)
    {
        double sum_dj = 0;
        for (int j = tau + 1; j <= (t - 1); j++) {
            sum_dj += (j - tau) * input.d.get(j);
        }
        return input.K + input.h * (sum_dj);
    }
}
