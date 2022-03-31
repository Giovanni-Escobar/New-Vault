/**
 * The class CoinSorterMachine uses the abstract class
 * Coin and its subclasses to read a file
 * of ints, converts them to coins, and then reports the total deposit and its details.
 * @version 3/31/2022
 * @author gescobar
 */

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class CoinSorterMachine {

    private ArrayList<Coin> coins;
    private int[] coinCount;
    private ArrayList<Coin> coinMap;

    /**
     * Constructor for the class
     */
    public CoinSorterMachine(){
        coins = new ArrayList<>();
        coinMap = new ArrayList<>();
        coinCount = new int[6];

        coinMap.add(new Penny());
        coinMap.add(new Nickel());
        coinMap.add(new Dime());
        coinMap.add(new Quarter());
        coinMap.add(new HalfDollar());
        coinMap.add(new Dollar());
    }

    /**
     * Reads the file written by the user and then adds the corresponding Coin
     * that matches the value in the file to the arraylist coins
     */
    public void depositCoins(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the data file for coin deposit: ");
            String fileName = sc.nextLine();
            System.out.println("Depositing coins...");
            Scanner in = new Scanner(new File(fileName));
            while(in.hasNext()){
                int num = in.nextInt();
                Coin a = null;

                switch (numCase(num)){
                    case 1: a = new Penny();
                        break;
                    case 2: a = new Nickel();
                        break;
                    case 3: a = new Dime();
                        break;
                    case 4: a = new Quarter();
                        break;
                    case 5: a = new HalfDollar();
                        break;
                    case 6: a = new Dollar();
                        break;
                    case 7: break;
                }

                if(a == null){
                    System.out.println("Coin value " +num+ " not recognized.");
                }
                else{
                    coins.add(a);
                }
            }
            in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        for(Coin c : coins){
            fillPrivData(c);
        }
    }

    private int numCase(int a){
        if(a == 1){
            return 1;
        }
        else if(a == 5){
            return 2;
        }
        else if(a == 10){
            return 3;
        }
        else if(a == 25){
            return 4;
        }
        else if( a == 50){
            return 5;
        }
        else if( a == 100 ){
            return 6;
        }
        else{
            return 7;
        }

    }

    private void fillPrivData(Coin c){
        if(c instanceof Penny){
            coinCount[0]++;
        }
        else if(c instanceof Nickel){
            coinCount[1]++;
        }
        else if(c instanceof Dime){
            coinCount[2]++;
        }
        else if(c instanceof Quarter){
            coinCount[3]++;
        }
        else if(c instanceof HalfDollar){
            coinCount[4]++;
        }
        else if(c instanceof Dollar){
            coinCount[5]++;
        }
    }

    /**
     * Prints deposit summary using a DecimalFormat object.
     */
    public void printDepositSummary(){
        DecimalFormat df = new DecimalFormat("$0.00");

        System.out.println("Summary of deposit:");
        for(int i = 0; i < 6; i++){
            if (coinCount[i] == 1) {
                System.out.println("\t" + coinCount[i] + " " + coinMap.get(i).getName() +" "+
                        df.format(coinCount[i] * coinMap.get(i).getValue()) );
            }
            else {
                System.out.println("\t" + coinCount[i] + " " + coinMap.get(i).getPluralName() +" "+
                        df.format(coinCount[i] * coinMap.get(i).getValue()) );
            }
        }
        System.out.println("TOTAL DEPOSIT: "+ df.format(getTotalValue()));
    }

    /**
     * Calculates the total value of all Coin objects stored in coins as a double
     * @return the total balance.
     */
    public double getTotalValue(){
        double totalBalance = 0;
        for(Coin c : coins){
           totalBalance += c.getValue();;
        }
        return totalBalance;
    }

    /**
     * main method for the class
     * @param args
     */
    public static void main(String[] args) {
        CoinSorterMachine app = new CoinSorterMachine();
        app.depositCoins();
        app.printDepositSummary();
    }
}
