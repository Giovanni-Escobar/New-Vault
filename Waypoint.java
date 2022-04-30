/**
 * The Waypoint class creates the objects used in the TrailDatabase program.
 * @version 4/19/22
 * @author gescobar
 */

public class Waypoint { //implements Comparable<Waypoint>{
    private String type, name, state;
    private double toSpringer, toKatahdin;
    private int elevation;

    /**
     * Constructor for the class
     * @param t the type of waypoint
     * @param n the name of the waypoint
     * @param s the state of the waypoint
     * @param ts the distance to Springer of the waypoint
     * @param tk the distance to Katahdin of the waypoint
     * @param e the elevation of the waypoint
     */
    public Waypoint(String t, String n, String s, double ts, double tk, int e){
        type = t;
        name = n;
        state = s;
        toSpringer = ts;
        toKatahdin = tk;
        elevation = e;
    }

    /**
     * Copy constructor for the class
     * @param other the original waypoint
     */
    public Waypoint(Waypoint other){
        this(other.type, other.name, other.state, other.toSpringer, other.toKatahdin, other.elevation);
    }

    /**
     * @return returns the type of waypoint
     */
    public String getType() {
        return type;
    }

    /**
     * @return returns the name of the waypoint
     */
    public String getName() {
        return name;
    }

    /**
     * @return returns the waypoint's state
     */
    public String getState() {
        return state;
    }

    /**
     * @return returns the distance to Springer from the waypoint
     */
    public double getToSpringer() {
        return toSpringer;
    }

    /**
     * @return returns the distance to Katahdin from the waypoint
     */
    public double getToKatahdin() {
        return toKatahdin;
    }

    /**
     * @return returns the elevation of the waypoint
     */
    public int getElevation() {
        return elevation;
    }

    /**
     * the toString method formats the information into a string.
     * @return the waypoint in the form of a string.
     */
    @Override
    public String toString() {
        return type + "\t" + name + "\t" + state + "\t" + toSpringer + "\t" + toKatahdin + "\t" + elevation;
    }

}
