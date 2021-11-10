import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * This program calculates the user's BMI as a ratio of the user's height, in meters
 * divided by weight in kgs squared.
 * @version 11.9.2021
 * @author gescobar
 */

public class BMICalculator {
    /** Convert English to metric units, perform the BMI calculation.
     * NOTE: this method must properly handle bad data */
    public static double computeBMI(int inches, int pounds){
        if(inches <= 0 || pounds <= 0)
            return 0;
        return pounds *.454/ Math.pow(inches*0.0254, 2) ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String textHeight;
        int intHeight, intWeight, qtPos, dblQtPos;
        DecimalFormat df = new DecimalFormat("0.00");
        while (true) {
            try {
                System.out.print("Enter your height in feet and inches (Ex 6'1\") or \"Q\" to quit: ");
                textHeight = sc.nextLine();
                qtPos = textHeight.indexOf("'");
                dblQtPos = textHeight.indexOf("\"");
                if (qtPos != -1 && dblQtPos != -1 ) {
                    int feet = Integer.parseInt(textHeight.substring(0, qtPos));
                    int inches= Integer.parseInt(textHeight.substring(qtPos + 1, dblQtPos));
                    if (inches < 0 || inches > 11 || feet >= 0) {
                        intHeight = feet * 12 + inches;
                        System.out.print("Enter your weight in pounds: ");
                        intWeight = sc.nextInt();
                        System.out.println("Your BMI, expressed as weight(kg)/height(m)^2: " +
                                df.format(computeBMI(intHeight, intWeight)) + " kg/m^2");
                        sc.nextLine();
                    }
                    else
                        System.out.println("I'm sorry but it seems you have entered invalid data. Please try again.");;
                }
                else {
                    if (textHeight.toUpperCase().equals("Q"))
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Data, more details here: ");
                System.out.println(e);
                if (e instanceof java.util.InputMismatchException)
                    sc.nextLine();
            }
        }
        System.out.println("*Program Finished*");
        sc.close();
    }

}
