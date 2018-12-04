package ttr.up.edu.tickettoride;

/**
 * class Route
 * <p>
 * a class to represent a connection in the graph of the board
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 */
public class Route {
    City city;
    int length, playerNum;
    String color;

    /**
     * Constructor to create a new route
     *
     * @param c  city which the route connects to
     * @param l  length of the route
     * @param c1 color of the route
     */
    public Route(City c, int l, String c1) {
        city = c;
        length = l;
        color = c1;
        playerNum = -1;
    }

    /**
     * Deep-copy constructor
     *
     * @param r route to copy
     */
    public Route(Route r) {
        city = r.getCity();
        length = r.getLength();
        playerNum = r.getPlayerNum();
        color = r.getColor();
    }

    public City getCity() {
        return city;
    }

    public int getLength() {
        return length;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    //Getters/setters
    public void setPlayerNum(int playerNum) {
        this.playerNum = playerNum;
    }

    public String getColor() {
        return color;
    }
}