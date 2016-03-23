package fpptool.algos;

/**
 * Created by spookee on 23.03.16.
 */
public abstract class AbstractAlgo {

    protected final Input input;

    protected Output output;


    public AbstractAlgo(Input input) {
        this.input = input;
    }

    public Output doTheMagic() {

        Integer tau = 1;
        //Integer t = tau + 1;
        Integer T = input.d.size();

        Output output = new Output(Class.class.toString(), input);

        for (int t = tau + 1; t <= T; ) {
            double C_t = calcC(tau, t);
            double V_t = calcV(tau, t);
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
                t += 1;
            }
        }

        return output;
    }

    protected abstract double calcV(Integer tau, Integer t);

    protected abstract double calcC(Integer tau, Integer t);

    public void setOutput(Output output) {
        this.output = output;
    }
}
