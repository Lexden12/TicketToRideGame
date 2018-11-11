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

        HashMap<String, Route> routes = new HashMap<>();//routes for Vancouver
        routes.put("Calgary", new Route(calgary, 3, "grey"));
        routes.put("Seattle1", new Route(seattle, 1, "grey"));
        routes.put("Seattle2", new Route(seattle, 1, "grey"));
        vancouver.setRoutes(routes);

        routes = new HashMap<>();//routes for Calgary
        routes.put("Vancouver", new Route(vancouver, 3, "grey"));
        routes.put("Seattle", new Route(seattle, 4, "grey"));
        routes.put("Helena", new Route(helena, 4, "grey"));
        routes.put("Winnipeg", new Route(winnipeg, 6, "white"));
        calgary.setRoutes(routes);

        routes = new HashMap<>();//routes for Winnipeg
        routes.put("Calgary", new Route(calgary, 6, "white"));
        routes.put("Helena", new Route(helena, 4, "blue"));
        routes.put("Duluth", new Route(duluth, 4, "black"));
        routes.put("Sault St. Marie", new Route(saultStMarie, 6, "grey"));
        winnipeg.setRoutes(routes);

        routes = new HashMap<>();//routes for Sault St. Marie
        routes.put("Winnipeg", new Route(winnipeg, 6, "grey"));
        routes.put("Duluth", new Route(duluth, 3, "grey"));
        routes.put("Toronto", new Route(toronto, 2, "grey"));
        routes.put("Montreal", new Route(montreal, 5, "black"));
        saultStMarie.setRoutes(routes);

        routes = new HashMap<>();//routes for Montreal
        routes.put("Sault St. Marie", new Route(saultStMarie, 5, "black"));
        routes.put("Toronto", new Route(toronto, 3, "grey"));
        routes.put("New York", new Route(newYork, 3, "blue"));
        routes.put("Boston1", new Route(boston, 2, "grey"));
        routes.put("Boston2", new Route(boston, 2, "grey"));
        montreal.setRoutes(routes);

        routes = new HashMap<>();//routes for Seattle
        routes.put("Calgary", new Route(calgary, 4, "grey"));
        routes.put("Helena", new Route(helena, 6, "yellow"));
        routes.put("Portland1", new Route(portland, 1, "grey"));
        routes.put("Portland2", new Route(portland, 1, "grey"));
        routes.put("Vancouver1", new Route(vancouver, 1, "grey"));
        routes.put("Vancouver2", new Route(vancouver, 1, "grey"));
        vancouver.setRoutes(routes);

        routes = new HashMap<>(); //routes for Helena
        routes.put("Calgary", new Route(calgary, 4, "grey"));
        routes.put("Winnipeg", new Route(winnipeg, 4, "blue"));
        routes.put("Duluth", new Route(duluth, 6, "orange"));
        routes.put("Omaha", new Route(omaha, 4, "red"));
        routes.put("Denver", new Route(denver, 4, "green"));
        routes.put("Salt Lake City", new Route(saltLakeCity, 3, "pink"));
        routes.put("Seattle", new Route(seattle, 6, "yellow"));
        helena.setRoutes(routes);

        routes = new HashMap<>(); //routes for Portland
        routes.put("Seattle1", new Route(seattle, 1, "grey"));
        routes.put("Seattle2", new Route(seattle, 1, "grey"));
        routes.put("Salt Lake City", new Route(saltLakeCity, 6, "blue"));
        routes.put("San Francisco1", new Route(sanFrancisco, 5, "pink"));
        routes.put("San Francisco2", new Route(sanFrancisco, 5, "green"));
        portland.setRoutes(routes);

        routes = new HashMap<>(); //routes for San Francisco
        routes.put("Portland1", new Route(portland, 5, "pink"));
        routes.put("Portland2", new Route(portland, 5, "green"));
        routes.put("Salt Lake City1", new Route(saltLakeCity, 5, "orange"));
        routes.put("Salt Lake City2", new Route(saltLakeCity, 5, "white"));
        routes.put("Los Angeles1", new Route(losAngeles, 3, "pink"));
        routes.put("Los Angeles2", new Route(losAngeles, 3, "yellow"));
        losAngeles.setRoutes(routes);

        routes = new HashMap<>(); //routes for los angeles
        routes.put("San Francisco1", new Route(sanFrancisco, 3, "pink"));
        routes.put("San Francisco2", new Route(sanFrancisco, 3, "yellow"));
        routes.put("Las Vegas", new Route(lasVegas, 2, "grey"));
        routes.put("Phoenix", new Route(phoenix, 3, "grey"));
        routes.put("El Paso", new Route(elPaso, 6, "black"));
        losAngeles.setRoutes(routes);

        routes = new HashMap<>(); //routes for salt lake city
        routes.put("Portland", new Route(portland, 6, "blue"));
        routes.put("Helena", new Route(helena, 3, "pink"));
        routes.put("Denver1", new Route(denver, 3, "red"));
        routes.put("Denver2", new Route(denver, 3, "yellow"));
        routes.put("Las Vegas", new Route(lasVegas, 3, "orange"));
        routes.put("San Francisco1", new Route(sanFrancisco, 5, "orange"));
        routes.put("San Francisco2", new Route(sanFrancisco, 5, "white"));
        saltLakeCity.setRoutes(routes);

        routes = new HashMap<>(); //routes for Las Vegas
        routes.put("Salt Lake City", new Route(saltLakeCity, 3, "orange"));
        routes.put("Los Angeles", new Route(losAngeles, 2, "grey"));
        lasVegas.setRoutes(routes);

        routes = new HashMap<>(); //routes for Phoenix
        routes.put("Los Angeles", new Route(losAngeles, 3, "grey"));
        routes.put("Denver", new Route(denver, 5, "white"));
        routes.put("Santa Fe", new Route(santaFe, 3, "grey"));
        routes.put("El Paso", new Route(elPaso, 3, "grey"));
        phoenix.setRoutes(routes);

        routes = new HashMap<>(); //routes for El Paso
        routes.put("Los Angeles", new Route(losAngeles, 6, "black"));
        routes.put("Phoenix", new Route(phoenix, 3, "grey"));
        routes.put("Santa Fe", new Route(santaFe, 2, "grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 5, "yellow"));
        routes.put("Dallas", new Route(dallas, 4, "red"));
        routes.put("Houston", new Route(houston, 6, "green"));
        elPaso.setRoutes(routes);

        routes = new HashMap<>(); //routes for Santa Fe
        routes.put("Phoenix", new Route(phoenix, 3, "grey"));
        routes.put("Denver", new Route(denver, 2, "grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 3, "blue"));
        routes.put("El Paso", new Route(elPaso, 2, "grey"));
        santaFe.setRoutes(routes);

        routes = new HashMap<>(); //routes for Denver
        routes.put("Helena", new Route(helena, 4, "green"));
        routes.put("Salt Lake City1", new Route(saltLakeCity, 3, "red"));
        routes.put("Salt Lake City2", new Route(saltLakeCity, 3, "yellow"));
        routes.put("Phoenix", new Route(phoenix, 5, "white"));
        routes.put("Santa Fe", new Route(santaFe, 2, "grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 4, "red"));
        routes.put("Kansas City1", new Route(kansasCity, 4, "orange"));
        routes.put("Kansas City2", new Route(kansasCity, 4, "black"));
        routes.put("Omaha", new Route(omaha, 4, "pink"));
        denver.setRoutes(routes);

        routes = new HashMap<>(); //routes for Omaha
        routes.put("Helena", new Route(helena, 5, "red"));
        routes.put("Duluth1", new Route(duluth, 1, "grey"));
        routes.put("Duluth2", new Route(duluth, 1, "grey"));
        routes.put("Chicago", new Route(chicago, 4, "blue"));
        routes.put("Kansas City1", new Route(kansasCity, 1, "grey"));
        routes.put("Kansas City2", new Route(kansasCity, 1, "grey"));
        routes.put("Denver", new Route(denver, 4, "pink"));
        denver.setRoutes(routes);

        routes = new HashMap<>(); //routes for Duluth
        routes.put("Helena", new Route(helena, 6, "orange"));
        routes.put("Winnipeg", new Route(winnipeg, 4, "black"));
        routes.put("Sault St. Marie", new Route(saultStMarie, 3, "grey"));
        routes.put("Toronto", new Route(toronto, 6, "pink"));
        routes.put("Chicago", new Route(chicago, 3, "red"));
        routes.put("Omaha1", new Route(omaha, 1, "grey"));
        routes.put("Omaha2", new Route(omaha, 1, "grey"));
        duluth.setRoutes(routes);

        routes = new HashMap<>(); //routes for Kansas City
        routes.put("Omaha1", new Route(omaha, 1, "grey"));
        routes.put("Omaha2", new Route(omaha, 1, "grey"));
        routes.put("Saint Louis1", new Route(saintLouis, 2, "blue"));
        routes.put("Saint Louis2", new Route(saintLouis, 2, "pink"));
        routes.put("Oklahoma City1", new Route(oklahomaCity, 2, "grey"));
        routes.put("Oklahoma City2", new Route(oklahomaCity, 2, "grey"));
        routes.put("Denver1", new Route(denver, 5, "orange"));
        routes.put("Denver2", new Route(denver, 5, "black"));
        kansasCity.setRoutes(routes);

        routes = new HashMap<>(); //routes for Oklahoma City
        routes.put("Kansas City1", new Route(kansasCity, 2, "grey"));
        routes.put("Kansas City 2", new Route(kansasCity, 2, "grey"));
        routes.put("Little Rock", new Route(littleRock, 2, "grey"));
        routes.put("Dallas1", new Route(dallas, 2, "grey"));
        routes.put("Dallas2", new Route(dallas, 2, "grey"));
        routes.put("El Paso", new Route(elPaso, 5, "yellow"));
        routes.put("Santa Fe", new Route(santaFe, 3, "blue"));
        routes.put("Denver", new Route(denver, 4, "red"));
        oklahomaCity.setRoutes(routes);

        routes = new HashMap<>(); //routes for Dallas
        routes.put("El Paso", new Route(elPaso, 4, "red"));
        routes.put("Oklahoma City1", new Route(oklahomaCity, 2, "grey"));
        routes.put("Oklahoma City2", new Route(oklahomaCity, 2, "grey"));
        routes.put("Little Rock", new Route(littleRock, 2, "grey"));
        routes.put("Houston1", new Route(houston, 1, "grey"));
        routes.put("Houston2", new Route(houston, 1, "grey"));
        dallas.setRoutes(routes);

        routes = new HashMap<>(); //routes for Houston
        routes.put("Dallas1", new Route(dallas, 1, "grey"));
        routes.put("Dallas2", new Route(dallas, 1, "grey"));
        routes.put("New Orleans", new Route(newOrleans, 2, "grey"));
        routes.put("El Paso", new Route(elPaso, 6, "green"));
        houston.setRoutes(routes);

        routes = new HashMap<>(); //rotues for New Orleans
        routes.put("Houston", new Route(houston, 2, "grey"));
        routes.put("Little Rock", new Route(littleRock, 3, "green"));
        routes.put("Atlanta1", new Route(atlanta, 4, "yellow"));
        routes.put("Atlanta2", new Route(atlanta, 4, "orange"));
        routes.put("Miami", new Route(miami, 6, "red"));
        newOrleans.setRoutes(routes);

        routes = new HashMap<>(); //routes for Little Rock
        routes.put("Dallas", new Route(dallas, 2, "grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 2, "grey"));
        routes.put("Saint Louis", new Route(saintLouis, 2, "grey"));
        routes.put("Nashville", new Route(nashville, 3, "white"));
        routes.put("New Orleans", new Route(newOrleans, 3, "green"));
        littleRock.setRoutes(routes);

        routes = new HashMap<>(); //routes for Saint Louis
        routes.put("Little Rock", new Route(littleRock, 2, "grey"));
        routes.put("Kansas City1", new Route(kansasCity, 2, "blue"));
        routes.put("Kansas City2", new Route(kansasCity, 2, "pink"));
        routes.put("Chicago1", new Route(chicago, 2, "green"));
        routes.put("Chicago2", new Route(chicago, 2, "white"));
        routes.put("Pittsburgh", new Route(pittsburgh, 5, "green"));
        routes.put("Nashville", new Route(nashville, 2, "grey"));
        saintLouis.setRoutes(routes);

        routes = new HashMap<>(); //routes for Chicago
        routes.put("Saint Louis1", new Route(saintLouis, 2, "green"));
        routes.put("Saint Louis2", new Route(saintLouis, 2, "white"));
        routes.put("Omaha", new Route(omaha, 4, "blue"));
        routes.put("Duluth", new Route(duluth, 3, "red"));
        routes.put("Toronto", new Route(toronto, 4, "white"));
        routes.put("Pittsburgh", new Route(pittsburgh, 3, "orange"));
        routes.put("Pittsburgh", new Route(pittsburgh, 3, "black"));
        chicago.setRoutes(routes);

        routes = new HashMap<>(); //routes for Toronto
        routes.put("Sault St. Marie", new Route(saultStMarie, 2, "grey"));
        routes.put("Montreal", new Route(montreal, 3, "grey"));
        routes.put("Pittsburgh", new Route(pittsburgh, 2, "grey"));
        routes.put("Phoenix", new Route(phoenix, 3, "grey"));
        routes.put("Chicago", new Route(chicago, 4, "white"));
        routes.put("Duluth", new Route(duluth, 6, "pink"));
        routes.put("Phoenix", new Route(phoenix, 3, "grey"));
        toronto.setRoutes(routes);

        routes = new HashMap<>(); //routes for Pittsburgh
        routes.put("Chicago1", new Route(chicago, 3, "black"));
        routes.put("Chicago2", new Route(chicago, 3, "orange"));
        routes.put("Toronto", new Route(toronto, 2, "grey"));
        routes.put("New York1", new Route(newYork, 2, "white"));
        routes.put("New York2", new Route(newYork, 2, "green"));
        routes.put("Washington", new Route(washington, 2, "grey"));
        routes.put("Raleigh", new Route(raleigh, 2, "grey"));
        routes.put("Nashville", new Route(nashville, 4, "yellow"));
        routes.put("Saint Louis", new Route(saintLouis, 5, "green"));
        pittsburgh.setRoutes(routes);

        routes = new HashMap<>(); //routes for Nashville
        routes.put("Saint Louis", new Route(saintLouis, 2, "grey"));
        routes.put("Pittsburgh", new Route(pittsburgh, 4, "yellow"));
        routes.put("Raleigh", new Route(raleigh, 3, "black"));
        routes.put("Atlanta", new Route(atlanta, 1, "grey"));
        routes.put("Little Rock", new Route(littleRock, 3, "white"));
        nashville.setRoutes(routes);

        routes = new HashMap<>(); //routes for Atlanta
        routes.put("Nashville", new Route(nashville, 1, "grey"));
        routes.put("Raleigh1", new Route(raleigh, 2, "grey"));
        routes.put("Raleigh2", new Route(raleigh, 2, "grey"));
        routes.put("Charleston", new Route(charleston, 2, "grey"));
        routes.put("Miami", new Route(miami, 5, "blue"));
        routes.put("New Orleans1", new Route(newOrleans, 4, "yellow"));
        routes.put("New Orleans2", new Route(newOrleans, 4, "orange"));
        routes.put("Phoenix", new Route(phoenix, 3, "grey"));
        atlanta.setRoutes(routes);

        routes = new HashMap<>(); //routes for Miami
        routes.put("New Orleans", new Route(newOrleans, 6, "red"));
        routes.put("Atlanta", new Route(atlanta, 5, "blue"));
        routes.put("Charleston", new Route(charleston, 4, "pink"));
        miami.setRoutes(routes);

        routes = new HashMap<>(); //routes for Charleston
        routes.put("Miami", new Route(miami, 4, "pink"));
        routes.put("Atlanta", new Route(atlanta, 2, "grey"));
        routes.put("Raleigh", new Route(raleigh, 2, "grey"));
        charleston.setRoutes(routes);

        routes = new HashMap<>(); //routes for Raleigh
        routes.put("Charleston", new Route(charleston, 2, "grey"));
        routes.put("Atlanta1", new Route(atlanta, 2, "grey"));
        routes.put("Atlanta2", new Route(atlanta, 2, "grey"));
        routes.put("Nashville", new Route(nashville, 3, "black"));
        routes.put("Pittsburgh", new Route(pittsburgh, 2, "grey"));
        routes.put("Washington1", new Route(washington, 2, "grey"));
        routes.put("Washington2", new Route(washington, 2, "grey"));
        raleigh.setRoutes(routes);

        routes = new HashMap<>(); //routes for Washington
        routes.put("Raleigh1", new Route(raleigh, 2, "grey"));
        routes.put("Raleigh2", new Route(raleigh, 2, "grey"));
        routes.put("Pittsburgh", new Route(pittsburgh, 2, "grey"));
        routes.put("New York1", new Route(newYork, 2, "orange"));
        routes.put("New York2", new Route(newYork, 2, "black"));
        washington.setRoutes(routes);

        routes = new HashMap<>(); //routes for New York
        routes.put("Washington1", new Route(washington, 2, "orange"));
        routes.put("Washington2", new Route(washington, 2, "black"));
        routes.put("Pittsburgh1", new Route(pittsburgh, 2, "white"));
        routes.put("Pittsburgh2", new Route(pittsburgh, 2, "green"));
        routes.put("Montreal", new Route(montreal, 3, "blue"));
        routes.put("Boston1", new Route(boston, 2, "yellow"));
        routes.put("Boston2", new Route(boston, 2, "red"));
        newYork.setRoutes(routes);

        routes = new HashMap<>(); //routes for Boston
        routes.put("New York1", new Route(newYork, 2, "red"));
        routes.put("New York2", new Route(newYork, 2, "yellow"));
        routes.put("Montreal1", new Route(montreal, 2, "grey"));
        routes.put("Montreal2", new Route(montreal, 2, "grey"));
        boston.setRoutes(routes);
    }//TODO finish the adding the cities
    //TODO add isConnected method
}
