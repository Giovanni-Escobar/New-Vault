/**
 * "ScrabbleRackManager" is a program that generates 7 random letters and then finds all the
 * words that can be played with that set of letters. It then prints the set of letters and words
 * that can be played onto the screen.
 *
 * @version 3/25/22
 * @author gescobar
 */


import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ScrabbleRackManager {
    ArrayList<ArrayList<String>> dictionary;
    ArrayList<String> tileRack;
    private String alpha;

    /**
     * class constructor
     * */
    public ScrabbleRackManager(){
        alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        dictionary = new ArrayList<>();

        for(int i = 0; i < alpha.length(); i++){
            dictionary.add(new ArrayList<>());
        }

        buildDictionary();
        buildTileRack();
    }

    private void buildDictionary(){
        try{
            Scanner in = new Scanner(new File("SCRABBLE.txt"));
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

    private void buildTileRack(){
        tileRack = new ArrayList<>();
        int[] numLetters = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
        ArrayList<String> allTiles = new ArrayList<>();
        int index = 0;

        for(int count : numLetters){
            for(int i = 0; i < count; i++){
                allTiles.add(alpha.substring(index, index +1));
            }
            index += 1;
        }

        allTiles.add("");
        allTiles.add("");

        Collections.shuffle(allTiles);

        for(int i = 0; i< 7; i++){
            tileRack.add(allTiles.remove((int)(Math.random()*allTiles.size())));
        }


    }

    /**
     * Displays the contents of the player's tile rack.
     */
    public void printRack(){
        System.out.println("Letters in the rack: " + tileRack.toString());
    }

    /** Builds and returns an ArrayList of String objects that are values pulled from
     * the dictionary/database based on the available letters in the user's tile
     * rack.
     * @return playableWords
     */
    public ArrayList<String> getPlaylist(){
        ArrayList<String> playableWords = new ArrayList<>();
        for(int i =0; i < tileRack.size(); i++){
            for(String word : dictionary.get(alpha.indexOf(tileRack.get(i)))){
                if (isPlayable(word)){
                    playableWords.add(word);
                }
            }
        }
        return playableWords;
    }

    private boolean isPlayable(String word) {
        ArrayList<String> copy = new ArrayList<>(tileRack);
        for(int i = 0; i < word.length(); i++){
            if(!copy.remove(word.substring(i, i+1)))
                if(!copy.remove(""))
                     return false;
        }
        return true;
    }

    /**
     * Prints all playable words based on the letters in the tile rack
     */
    public void printMatches(){
        System.out.println("You can play the following words from the letters in your rack:");
        ArrayList<String> plays = getPlaylist();
        boolean bingo = false;

        if(plays.isEmpty()) {
            System.out.println("Sorry, NO words can be played from those tiles.");
        }
        else{
            for (int i = 0; i < plays.size(); i++) {
                String word = plays.get(i);
                if (word.length() == 7) {
                    word += "*";
                    bingo = true;
                }
                System.out.printf("%-10s", word);
                if ((i + 1) % 10 == 0) {
                    System.out.println();
                }
            }
            if(bingo)
                System.out.println("\n* Denotes BINGO");
        }
    }

    /**
     * Main method for the class
     */
    public static void main(String[] args){
        ScrabbleRackManager app = new ScrabbleRackManager();
        app.printRack();
        app.printMatches();
    }
}
