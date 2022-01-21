import java.util.*;
import java.io.*;

public class ScrabbleScorer {
    private ArrayList<String> dictionary;
    private int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10};
    private String alpha;



    public ScrabbleScorer(){
        dictionary = new ArrayList<>();
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public void buildDictionary(){
        try{
            Scanner in = new Scanner(new File("SCRABBLE_WORDS.txt"));
            while(in.hasNextLine()){
                dictionary.add(in.nextLine());
            }
            in.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isValidWord(String word){
        return Collections.binarySearch(dictionary, word) >= 0;
    }

    public int getWordScore(String word){
        int sum = 0;

        // parse word one letter at a time -- for loop, ""+charAt or substring
        for(int i = 0; i <= word.length()-1; i++){
            int num = points[alpha.indexOf(""+ word.charAt(i))];
            sum += num;
        }
        // find the index of each letter
        // add corresponding score/point value from points to sum value
        return sum; // total number of points
    }

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
                    // do the program
                    if(app.isValidWord(userWord.toUpperCase())){
                        System.out.println(userWord.toUpperCase() + " = " + app.getWordScore(userWord.toUpperCase()) + " points" );
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
