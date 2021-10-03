
public class RomanToDecimal {


    public static int romanToDecimal(String roman) {
        int sum = 0;
        String letter;
        for (int i = 0; i < roman.length(); i++) {
            letter = roman.substring(i, i + 1).toUpperCase();
            if (letter.equals("I"))
                sum += 1;
            else if (letter.equals("V"))
                sum += 5;
            else if (letter.equals("X"))
                sum += 10;
            else if (letter.equals("L"))
                sum += 50;
            else if (letter.equals("C"))
                sum += 100;
            else if (letter.equals("D"))
                sum += 500;
            else if (letter.equals("M"))
                sum += 1000;
            else
                return -1;

        }
        if (roman.indexOf("IV") != -1 || roman.indexOf("IX") != -1)
            sum -= 2;
        else if (roman.indexOf("XL") != -1 || roman.indexOf("XC") != -1)
            sum -= 20;
        else if (roman.indexOf("CD") != -1 || roman.indexOf("CM") != -1)
            sum -= 200;

        return sum;
    }

    public static String decimalToRoman(int num){
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanNumerals = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder romanNumeral = new StringBuilder();

        for(int i=0;i<values.length;i++) {
            while(num >= values[i]) {
                num -= values[i];
                romanNumeral.append(romanNumerals[i]);
            }
        }
        return romanNumeral.toString();
    }


    public static void main(String[] args) {

        for (String roman : args) {
            int decimal = romanToDecimal(roman.toUpperCase());
            String roman1 = decimalToRoman(decimal);
            if ((decimal == -1))
                System.out.println("Input: " + roman.toUpperCase() + " ==> Output: Invalid Input");
            else if ((roman.toUpperCase()).equals(roman1) == false)
                System.out.println("Input: " + roman.toUpperCase() + " ==> Output: Logically incorrect input, \'"
                        + roman1 + "\' would be its correct form. Please try again.");
            else
                System.out.println("Input: " + roman.toUpperCase() + " ==> Output: " + decimal);
            }
            System.out.println("*End of Program*");
        }
    }
