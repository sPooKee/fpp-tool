package fpptool.algos;

public class Lot
{

    public Lot(double q, long tau, double K, double h)
    {
        this.q = q;
        this.tau = tau;
        this.K = K;
        this.h = h;
    }

    /**
     * Losgröße
     */
    public final double q;

    /**
     * Produktionszyklus
     */
    public final long tau;

    /**
     * Rüstkosten fürs Los
     */
    public final double K;

    /**
     * Lagerkosten fürs Los
     */
    public final double h;

    public double sumCosts()
    {
        return K + h;
    }
}
