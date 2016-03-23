package fpptool.alogs.impl;

import fpptool.alogs.AbstractAlgo;
import fpptool.alogs.Input;
import fpptool.alogs.Lot;
import fpptool.alogs.Output;

public class StkKostVerfAlgo extends AbstractAlgo {


    public StkKostVerfAlgo(Input input) {
        super(input);
    }

    @Override
    public Output doTheMagic() {

        Integer tau = 1;
        //Integer t = tau + 1;
        Integer T = input.d.size();

        Output output = new Output(StkKostVerfAlgo.class.toString(), input);

        for (int t = tau + 1; t <= T; ) {
            double C_t = calcC(tau, t);
            double V_t = calcV(tau, t );
            boolean b = C_t <= V_t;
            // Schritt 4
            if (b && t < T) {
                t += 1;
                continue;
            }

            // Schritt 5

            if (!b) {
                double q_tau = 0.0;
                for (int i = tau; i <= (t - 1); i++) {
                    q_tau += input.d.get(i);
                }
                double h_tau = 0;
                for (int i = tau; i < t; i++) {
                    h_tau += input.d.get(i) * (i - tau) * input.h;
                }
                output.lots.put(tau, new Lot(q_tau, tau, input.K, h_tau));
                tau = t;
                t = tau + 1;
                if (t <= T) {
                    continue;
                } else {
                    q_tau = input.d.get(T);
                    output.lots.put(tau, new Lot(q_tau, tau, input.K, 0.0));
                    continue;
                }
            } else if (b && t == T) {
                double q_tau = 0.0;
                for (int i = tau; i <= T; i++) {
                    q_tau += input.d.get(i);
                }
                output.lots.put(tau, new Lot(q_tau, tau, input.K, 0.0));
            }
        }

        return output;
    }

    private double calcV(Integer tau, Integer t){
        return calcC(tau, t - 1);
    }

    private double calcC(Integer tau, Integer t) {
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

