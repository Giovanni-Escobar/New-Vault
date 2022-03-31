/**
 * The class Quarter is a subclass of Coin
 * @version 3/31/2022
 * @author gescobar
 */

public class Quarter extends Coin{

    /**
     * Utility accessor method
     * @return returns the value of Quarter
     */
    public double getValue() {
        return 0.25;
    }

    /**
     * Utility accessor method
     * @return returns Quarter's name
     */
    public String getName() {
        return "quarter";
    }
}
