import java.util.*;
import java.io.*;

/**
 * ScrabbleScorer takes the user's input, verifies if it's a valid word in its dictionary,
 * and scores the word for the user.
 * @version Monday 1/24/22
 * @author gescobar
 */
public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;

    /**
     * Constructor for the class.
     */
    public ScrabbleScorer(){
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    /**
     * Reads the text file "SCRABBLE_WORDS.txt", adds it to dictionary,
     * and then sorts it.
     */
    public void buildDictionary(){
        try{
            Scanner in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(in.hasNext()){
                dictionary.add(in.nextLine());
            }
            in.close();
            Collections.sort(dictionary);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches through the array list "dictionary" and verifies whether
     * the user's input is a valid word.
     * @param word the user's input.
     * @return returns negative numbers if the word is not in dictionary, and
     * it returns positive numbers or "0" if it is.
     */
    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    /**
     * Calculates the amount of points for each of the user's words.
     * @param word user's input.
     * @return returns the amount of points the word is worth.
     */
    public int getWordScore(String word){
        int sum = 0;
        for(int i = 0; i <= word.length()-1; i++){
            int num = points[alpha.indexOf(""+ word.charAt(i))];
            sum += num;
        }
        return sum;
    }

    /**
     * The main method of the class ScrabbleScorer where it prints the user's score for their word.
     * @param args
     */
    public static void main(String[] args) {
        ScrabbleScorer app = new ScrabbleScorer();
        app.buildDictionary();
        System.out.println("* Welcome to the Scrabble Word Scorer app *");
        String userWord;
        Scanner userIn = new Scanner(System.in);
        try {
            while(true){
                System.out.println("Enter a word to score or 0 to quit: ");
                userWord = userIn.nextLine();
                if(userWord.equals("0"))
                    break;
                else{
                    if(app.isValidWord(userWord.toUpperCase())){
                        System.out.println(userWord + " = " + app.getWordScore(userWord.toUpperCase()) + " points" );
                    }
                    else if(userWord.isBlank()){
                        System.out.println("Please use a word");
                    }
                    else{
                        System.out.println(userWord.toUpperCase() + " is not a valid word in the dictionary");
                    }
                }
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Exiting the program thanks for playing");
    }
}
