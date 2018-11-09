package ttr.up.edu.tickettoride;

import java.util.HashMap;

public class City {
    String name;
    HashMap<String, Route> routes;

    public City(String name){
        this.name = name;
    }

    public City(City c){
        name = c.getName();
        for(String k:c.getRoutes().keySet()){
            routes.put(k, c.getRoutes().get(k));
        }
    }

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
