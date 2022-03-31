/**
 * The classPenny is a subclass of Coin
 * @version 3/31/2022
 * @author gescobar
 */

public class Penny extends Coin{

    /**
     * Utility accessor method
     * @return returns the value of Penny
     */
    public double getValue() {
        return 0.01;
    }

    /**
     * Utility accessor method
     * @return returns Penny's name
     */
    public String getName() {
        return "penny";
    }
}
