import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * BaseConverter opens a data file, reads, converts numbers, prints
 * @version Monday 11/22/2021
 * @author gescobar
 */
public class BaseConverter {

    /**
     * Constructor for class.
     */
    public BaseConverter()  {

    }

    /**
     * Converts a String num in fromBase to base-10 int.
     * @param num String being converted.
     * @param fromBase String of original base num was in.
     * @return returns num in base-10 int.
     */
    public int strToInt(String num, String fromBase)    {

        String alpha = "0123456789ABCDEF";

        int base = Integer.parseInt(fromBase);
        int sum = 0;
        int exp = 0;

        for (int i = num.length()-1; i >= 0; i--){
            sum += alpha.indexOf(num.charAt(i))* Math.pow(base, exp);
            exp++;
        }

        return sum;
    }

    /**
     * Converts a base-10 int to a String number of base toBase.
     * @param num base-10 int being converted.
     * @param toBase the base num is being converted to.
     * @return returns the converted num as a string.
     */

    public String intToStr(int num, int toBase)     {

        String alpha = "0123456789ABCDEF";
        String str = "";

        while (num > 0){
            str = alpha.charAt(num % toBase) + str;
            num /= toBase;
        }

        if (str.equals(""))
            return "0";

        return str;
    }

    /**
     * Opens the file stream, inputs data one line at a time, converts, prints
     * the result to the console window and writes data to the output stream.
     */
    public void inputConvertPrintWrite() {
        Scanner sc = null;
        PrintWriter pw = null;

        try {
            sc = new Scanner(new File("datafiles/values30.dat"));
            pw = new PrintWriter("datafiles/converted.dat");

            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split("\t");

                int fromBase = Integer.parseInt(line[1]);
                int toBase = Integer.parseInt(line[2]);

                String num = line[0];
                String convertedNum = intToStr(strToInt(num, line[1]), toBase);

                if (fromBase < 2 || fromBase > 16)
                    System.out.println("Invalid input base " + fromBase);

                else if (toBase < 2 || toBase > 16)
                    System.out.println("Invalid output base " + toBase);

                else {
                    System.out.println(num + " base " + fromBase + " = " + convertedNum
                            + " base " + toBase );
                    pw.println(num + "\t" + fromBase + "\t" + convertedNum + "\t" + toBase);
                }
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        if (sc != null)
            sc.close();

        if (pw != null)
            pw.close();
    }

    /**
     * Main method for class BaseConverter.
     * @param args command line arguments. If needed.
     */
    public static void main(String[] args) {
        BaseConverter app = new BaseConverter();
        app.inputConvertPrintWrite();
    }
}
