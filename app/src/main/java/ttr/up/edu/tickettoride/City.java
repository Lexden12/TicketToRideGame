package ttr.up.edu.tickettoride;

import java.util.HashMap;
/**
 * class City
 *
 * a class to represent a node in the graph of the board
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */
public class City {
    String name;
    HashMap<String, Route> routes;

    /**
     * Constructor which creates a new City given a name
     * @param name the name to give the city
     */
    public City(String name){
        this.name = name;
    }

    /**
     * Deep-copy constructor
     * @param c city to copy
     */
    public City(City c){
        name = c.getName();
        for(String k:c.getRoutes().keySet()){
            routes.put(k, c.getRoutes().get(k));
        }
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
}
