/**
 * WaypointComparator creates a comparator to then be used in the MergeSort class to
 * be able to compare the waypoints to the user's liking in the TrailDatabase class.
 * @version 4/19/22
 * @author gescobar
 */

import java.util.Comparator;

public class WaypointComparator implements Comparator<Waypoint> {
    private int category;
    private boolean asc;

    /**
     * Constructor for the class.
     * @param c the category the user wants to sort by.
     * @param a the order they want the sorted list to be in.
     */
    public WaypointComparator(int c, boolean a){
        category = c;
        asc = a;
    }

    /**
     * Copy constructor for the class that only takes an int.
     * @param c the category the user wants to sort by.
     */
    public WaypointComparator(int c){
        category = c;
        asc = true;
    }

    /**
     * Copy constructor for the class that does not take any parameters.
     */
    public  WaypointComparator(){
        category = 4;
        asc = true;
    }

    /**
     * The compare method compares the waypoint objects depending on the category
     * that was chosen.
     * @param one the first waypoint being compared.
     * @param two the other waypoint being compared.
     * @return the difference between the two.
     */
    public int compare(Waypoint one, Waypoint two){
       int diff = 0;

       if (category == 1){
            diff = one.getType().compareTo(two.getType());
       }
       else if (category == 2){
           diff = one.getName().compareTo(two.getName());
       }
       else if (category == 3){
           diff = one.getState().compareTo(two.getState());
       }
       else if (category == 4){
           Double d1 = one.getToSpringer();
           Double d2 = two.getToSpringer();
           diff = d1.compareTo(d2);
       }
       else if (category == 5){
           Double d1 = one.getToKatahdin();
           Double d2 = two.getToKatahdin();
           diff = d1.compareTo(d2);
       }
       else if (category == 6){
           diff = one.getElevation() - two.getElevation();
       }

       return (asc) ? diff : -diff;
    }
}
