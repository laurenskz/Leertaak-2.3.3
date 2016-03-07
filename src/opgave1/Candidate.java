package opgave1;

/**
 * Created by Laurens on 22-2-2016.
 */
public class Candidate {

    public static final Candidate INVALID = new Candidate('X');

    private char value;

    public Candidate(char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ""+value;
    }
}
