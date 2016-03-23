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

    public abstract Output doTheMagic();

    public void setOutput(Output output) {
        this.output = output;
    }
}
