package ttr.up.edu.tickettoride;

import java.util.ArrayList;
import java.util.HashMap;

public class CityGraph {
    ArrayList<City> cities;
    public CityGraph(){
        City vancouver = new City("Vancouver");
        City calgary = new City("Calgary");
        City winnipeg = new City("Winnipeg");
        City saultStMarie = new City("Sault St. Marie");
        City montreal = new City("Montreal");
        City seattle = new City("Seattle");
        City helena = new City("Helena");
        City duluth = new City("Duluth");
        City toronto = new City("Toronto");
        City boston = new City("Boston");
        City newYork = new City("New York");
        City pittsburgh = new City("Pittsburgh");
        City chicago = new City("Chicago");
        City omaha = new City("Omaha");
        City portland = new City("Portland");
        City washington = new City("Washington");
        City raleigh = new City("Raleigh");
        City nashville = new City("Nashville");
        City saintLouis = new City("Saint Louis");
        City kansasCity= new City("Kansas City");
        City denver = new City("Denver");
        City saltLakeCity = new City("Salt Lake City");
        City sanFrancisco = new City("San Francisco");
        City lasVegas = new City("Las Vegas");
        City santaFe = new City("Santa Fe");
        City oklahomaCity = new City("Oklahoma City");
        City littleRock = new City("Little Rock");
        City atlanta = new City("Atlanta");
        City charleston = new City("Charleston");
        City losAngeles = new City("Los Angeles");
        City phoenix = new City("Phoenix");
        City elPaso = new City("El Paso");
        City dallas = new City("Dallas");
        City houston = new City("Houston");
        City newOrleans = new City("New Orleans");
        City miami = new City("Miami");
        HashMap<String, Route> routes = new HashMap<>();
        routes.put("Calgary", new Route(calgary, 3, "grey"));
        routes.put("Seattle1", new Route(seattle, 1, "grey"));
        routes.put("Seattle2", new Route(seattle, 1, "grey"));
        vancouver.setRoutes(routes);
        routes = new HashMap<>();

    }//TODO finish the adding the cities
    //TODO add isConnected method
}
