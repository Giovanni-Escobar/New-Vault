/**
 * "HolyGrail" is a program that asks for the user's information. It then
 * repeats this information back to the user at the end of the program
 *
 * @version 09/15/2021
 * @author gescobar
 */

import java.util.Scanner;

public class HolyGrail {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("* A chat with the bridge keeper * " +
                "\nWho would cross the Bridge of Death must answer me these questions three, ere the other side he see.");
        System.out.print("Question 1: What is your name? ");
        String name = sc.nextLine();
        System.out.print("Question 2: What is your quest? ");
        String quest = sc.nextLine();
        System.out.print("Question 3: What is your favorite color? ");
        String color = sc.nextLine();
        System.out.println("King Arthur says, \"You have to know these things when you're a king, you know.\"" +
                "\nYour name is: " + name +
                "\nYour quest is: " + quest +
                "\nYour favorite color is: " + color +
                "\n* end of program *");
        sc.close();
    }
}
