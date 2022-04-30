/**
 * "TrailDatabase" is the program that reads through a list of locations on a trail, sorts that list
 * to the user's liking, and then prints out the sorted list.
 * @version 4/19/22
 * @author gescobar
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TrailDatabase {
    private ArrayList<Waypoint> database;

    /**
     * constructor for the class.
     * it also fills the database with waypoints
     */
    public TrailDatabase() {
        database = new ArrayList<>();
        populateDatabase();
    }

    /**
     * populateDatabase method reads the file "apptrailDb.txt", breaks up the array,
     * then uses that data to create a waypoint object to add it to database.
     */
    public void populateDatabase(){
        try{
            Scanner sc = new Scanner(new File("apptrailDB.txt"));
            while(sc.hasNext()){
                String[] entry = sc.nextLine().split("\t");
                String t = entry[0];
                String n = entry[1];
                String s = entry[2];
                double tS = Double.parseDouble(entry[5]);
                double tK = Double.parseDouble(entry[6]);
                int e = Integer.parseInt(entry[7]);

                database.add(new Waypoint(t,n,s,tS,tK,e));
            }
            sc.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * startProgram prompts the user for how they want the database to be sorted.
     * it then calls the sortDb method to sort the database using the user's input.
     * it then prints the sorted database.
     */
    public void startProgram(){
        try{
            Scanner sc = new Scanner(System.in);
            while(true) {
                System.out.println("\n"+"*** Welcome to the Appalachian Trail Database ***\n" +
                        "+ Menu of search terms to use for sorting waypoints +\n" +
                        "NA: by name\n" +
                        "DS: by distance to Springer\n" +
                        "DK: by distance to Katahdin\n" +
                        "EL: by elevation");
                System.out.println("Enter your preferred sort by term or 'Q' to quit: ");
                String search = sc.nextLine().toUpperCase();
                if(search.equals("Q"))
                    break;
                System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
                String order = sc.nextLine().toUpperCase();
                sortDB(search, order);
                System.out.println("\n");
                printDataBase();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * prints database
     */
    private void printDataBase(){
        for (Waypoint w : database){
            System.out.println(w);
        }
    }

    /**
     * sortDB take's the user's input and then calls MergeSort.sort using the database, which case
     * the waypoint comparator should follow, and the order the list should be in. This then sorts the
     * database.
     * @param s user's input for what the list should be sorted for.
     * @param o user's input for the order they want the list to be.
     */
    public void sortDB(String s, String o){
        if(s.equals("NA")){
            if(o.equals("A"))
                MergeSort.sort(database,2,true);
            else
                MergeSort.sort(database,2,false);
        }
        else if(s.equals("DS")){
            if(o.equals("A"))
                MergeSort.sort(database,4,true);
            else
                MergeSort.sort(database,4,false);
        }
        else if(s.equals("DK")){
            if(o.equals("A"))
                MergeSort.sort(database,5,true);
            else
                MergeSort.sort(database,5,false);
        }
        else if(s.equals("EL")){
            if(o.equals("A"))
                MergeSort.sort(database,6,true);
            else
                MergeSort.sort(database,6,false);
        }

    }

    /**
     * main method of the program.
     * @param args
     */
    public static void main(String[] args) {
        TrailDatabase app = new TrailDatabase();
        app.startProgram();
    }
}
