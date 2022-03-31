/**
 * The class Dollar is a subclass of Coin
 * @version 3/31/2022
 * @author gescobar
 */

public class Dollar extends Coin{

    /**
     * Utility accessor method
     * @return returns the value of Dollar
     */
    public double getValue() {
        return 1;
    }

    /**
     * Utility accessor method
     * @return returns Dollar's name
     */
    public String getName() {
        return "dollar";
    }
}
