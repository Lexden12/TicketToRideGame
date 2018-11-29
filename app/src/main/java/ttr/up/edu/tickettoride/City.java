package ttr.up.edu.tickettoride;

import java.util.HashMap;

/**
 * class City
 * <p>
 * a class to represent a node in the graph of the board
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 */

public class City {
    String name;
    HashMap<String, Route> routes;

    //information used for dijkstra's algorithm
    int cost;
    String parent;

    /**
     * Constructor which creates a new City given a name
     *
     * @param name the name to give the city
     */
    public City(String name) {
        this.name = name;
        this.cost = Integer.MAX_VALUE;
        this.parent = null;
    }

    /**
     * Deep-copy constructor
     *
     * @param c city to copy
     */
    public City(City c) {
        name = c.getName();
       /* for(String k:c.getRoutes().keySet()){
            routes.put(k, c.getRoutes().get(k));
        }*/
        this.cost = Integer.MAX_VALUE;
        this.parent = null;
    }

    //Getters/Setters
    public String getName() {
        return name;
    }

    public HashMap<String, Route> getRoutes() {
        return routes;
    }

    public void setRoutes(HashMap<String, Route> routes) {
        this.routes = routes;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }
}
