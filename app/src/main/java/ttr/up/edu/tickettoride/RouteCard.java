package ttr.up.edu.tickettoride;

/**
 * class RouteCard
 * <p>
 * a class to represent route cards
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version November 2018
 */

public class RouteCard extends Card {
    int value;

    public RouteCard(String name, int value) {
        super(name);
        this.value = value;
    }

    public RouteCard(RouteCard rc) {
        super(rc);
        this.value = rc.getValue();
    }

    /**
     * Makes a clone of this instance of RouteCard
     *
     * @return return a cloned instance of RouteCard
     */
    public RouteCard clone() {
        RouteCard c = new RouteCard(getName(), getValue());
        return c;
    }

    //getter
    public int getValue() {
        return value;
    }
}
