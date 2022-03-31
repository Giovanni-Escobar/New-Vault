/**
 * The class Coins is the abstract parent class for the coins used in CoinSorterMachine
 * @version 3/31/2022
 * @author gescobar
 */

public abstract class Coin {

    /**
     * Utility accessor method.
     * @return returns the value of the coin.
     */
    public abstract double getValue();

    /**
     * Utility accessor method.
     * @return returns the name of the coin
     */
    public abstract String getName();

    /**
     * Utility accessor method.
     * @return returns the plural version of the coin.
     */
    public String getPluralName(){
        if(getName().equals("penny")){
            return "pennies";
        }
        else if(getName().equals("nickel")){
            return "nickles";
        }
        else if(getName().equals("dime")){
            return "dimes";
        }
        else if(getName().equals("quarter")){
            return "quarters";
        }
        else if(getName().equals("half dollar")){
            return "half dollars";
        }
        else{
            return "dollars";
        }
    }
}
