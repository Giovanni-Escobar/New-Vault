/**
 * SubWordFinder reads a file and finds the words which contain sub-words and prints them in terminal.
 * @author gescobar
 * @version 02/01/2021
 */

import java.util.*;
import java.io.*;


public class SubWordFinder implements WordFinder {
    private ArrayList<ArrayList<String>> dictionary;  // jagged list
    private String alpha = "abcdefghijklmnopqrstuvwxyz";

    /**
     * constructor for the class that defines dictionary
     * and runs the method populateDicitonary()
     */
    public SubWordFinder(){
        dictionary = new ArrayList<>();
        for(int i = 0; i < alpha.length(); i++){
            dictionary.add(new ArrayList<String>());
        }
        populateDictionary();
    }

    /**
     * reads from the file "words_all_os.txt" and adds each word
     * to their corresponding bucket in dictionary.
     */
    public void populateDictionary(){
        try{
            Scanner in = new Scanner(new File("words_all_os.txt"));
            while(in.hasNext()){
                String word = in.nextLine();
                dictionary.get(alpha.indexOf(word.charAt(0))).add(word);
            }
            in.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * Binary search to verify if word is in dictionary.
     * @param index which bucket the word might be stored in. Determined by the words first letter.
     * @param word the original word being verified if it is in dictionary.
     * @return returns a positive number or zero if word is in dictionary or it return -1 if it's not.
     */
    private int indexOf(int index, String word){

        ArrayList<String> bucket = dictionary.get(index);
        int low, high;

        low = 0;
        high = bucket.size()-1;

        while(low <= high){
            int mid = (low+high)/2;
            if (bucket.get(mid).compareTo(word) == 0)
                return mid;
            else if(bucket.get(mid).compareTo(word) > 0)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }

    /**
     * Uses the indexOf method to verify if word is in dictionary.
     * @param word The item to be searched for in dictionary
     * @return returns true if word is in dictionary or false if it isn't.
     */
    @Override
    public boolean inDictionary(String word) {
        int index = alpha.indexOf(word.charAt(0));
        return indexOf(index, word) >= 0;
    }

    /**
     * Creates an Array List that is being added SubWord objects that return root = sub1 + sub2
     * @return returns the Array List that contains all SubWOrd object.
     */
    @Override
    public ArrayList<SubWord> getSubWords() {
        ArrayList<SubWord> subWords = new ArrayList<>();

        for(ArrayList<String> bucket : dictionary){
            for(String word : bucket){
                for(int i = 3; i< word.length()-2; i++){
                    String sub1= word.substring(0,i);
                    String sub2= word.substring(i);
                    if(inDictionary(sub1) && inDictionary(sub2)){
                        subWords.add(new SubWord(word, sub1, sub2));
                    }
                }
            }
        }
        return subWords;
    }

    /**
     * Main method for the class SubWordFinder. Prints all the sub-words found in the file it reads.
     * @param args
     */
    public static void main(String[] args) {
        SubWordFinder app = new SubWordFinder();
        ArrayList<SubWord> subs = app.getSubWords();
        for (SubWord temp: subs) {
            System.out.println(temp);
        }
        System.out.println("There are "+ subs.size() +" SubWord objects in total");
    }

}
