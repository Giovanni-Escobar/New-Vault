import java.util.Scanner;

/**
 * SimpleIOMath is a simple class that takes input/output from the user and stores that information
 * with this information it repeats it back and does math with the numerical information
 *
 * @version 09/27/2021
 * @author gescobar
 */
public class SimpleIOMath {

    private String name;
    private int age;
    private int favNumber;

    /**
     * Prompts the user for their information.
     */

    public void promptUser() {
        Scanner sc = new Scanner(System.in);

        System.out.println("* Sit yourself down, take a seat *\n" + "* All you gotta do is repeat after me *");

        System.out.print("Question 1: What is your name? ");
        name = sc.nextLine();

        System.out.print("Question 2: How old are you? ");
        age = sc.nextInt();

        System.out.print("What is your favorite number? ");
        favNumber = sc.nextInt();
    }

    /**
     * Prints the user's information
     */
    public void printInfo() {
        System.out.println("I'm gonna teach you how to sing it out" + "\nCome on, come on, come on" +
                "\nLet me tell you what it's all about" + "\nReading, writing, arithmetic" +
                "\nAre the branches of the learning tree");

        System.out.println("Your name is: " + name);

        System.out.println("Your age is: " + age);

        int newAge = age + 1;
        System.out.println("At your next birthday, you will turn " + newAge);

        System.out.println("The first prime factor of " + age + " is: " + smallestPrimeFactor(age));

        System.out.println("Your favorite number is: " + favNumber);

        System.out.println("Your favorite number squared is: " + Math.pow(favNumber, 2));

        System.out.println("* end of program *");

    }

    /**
     * Returns the first Prime factor of the user's age
     *
     * @param age
     * @return first prime factor
     */
    private int smallestPrimeFactor(int age) {
        for (int i = 2; i <= (int) (Math.sqrt(age)) + 1; i++) {
            if (age % i == 0) {
                return i;
            }
        }
        return age;
    }

    public static void main(String[] args){
        SimpleIOMath obj=new SimpleIOMath();
        obj.promptUser();
        obj.printInfo();
    }
}
