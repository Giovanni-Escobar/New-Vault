/**
 * MergeSort is the class that implements an algorithm that sorts an array list of waypoints
 * using a waypoint comparator.
 * @version 4/19/22
 * @author gescobar
 */

import java.util.ArrayList;

public class MergeSort {
    private static ArrayList<Waypoint> temp;

    /**
     * the sort method is called in the TrailDatabase program to sort the array list of waypoints
     * to the user's liking.
     * @param a the original array list
     * @param c the category for the waypoint comparator
     * @param as the order for the waypoint comparator to sort the waypoint in
     */
    public static void sort(ArrayList<Waypoint> a, int c, boolean as){
        int n = a.size();
        temp = new ArrayList<>(n);
        for(Waypoint b : a)
            temp.add(b);
        WaypointComparator way = new WaypointComparator(c,as);
        recursiveSort(a, 0, a.size()-1, way);
    }

    private static void recursiveSort(ArrayList<Waypoint> a, int from, int to, WaypointComparator w){
        WaypointComparator way = w;
        if(to - from < 2){
            if( to > from && way.compare(a.get(to), a.get(from)) < 0){
                Waypoint aTemp = new Waypoint(a.get(to));
                a.set(to, a.get(from));
                a.set(from, aTemp);
            }
        }

        else{
            int middle = (from+to)/2;
            recursiveSort(a, from, middle, way);
            recursiveSort(a, middle+1, to, way);
            merge(a, from, middle, to, way);
        }
    }

    private static void merge(ArrayList<Waypoint> a, int from, int middle, int to, WaypointComparator w){
        WaypointComparator way = w;
        int i = from, j = middle+1, k = from;
        while( i<= middle && j <= to){
            if(way.compare(a.get(i), a.get(j)) < 0){
                temp.set(k, a.get(i));
                i++;
            }
            else {
                temp.set(k, a.get(j));
                j++;
            }
            k++;
        }

        while( i<= middle){
            temp.set(k, a.get(i));
            i++;
            k++;
        }

        while(j <= to){
            temp.set(k, a.get(j));
            j++;
            k++;
        }

        for(k = from; k <= to; k++){
            a.set(k, temp.get(k));
        }

    }
}
