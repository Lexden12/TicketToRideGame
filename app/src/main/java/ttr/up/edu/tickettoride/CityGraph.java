package ttr.up.edu.tickettoride;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * class Card
 *
 * a class to initialize and store the graph that is all the cities and routes on the board
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */
public class CityGraph {
    HashMap<String, City> cities;

    /**
     * Constructor which creates a new CityGraph from scratch
     */
    public CityGraph(){
        cities = new HashMap<>();
        City vancouver = new City("Vancouver"); cities.put("Vancouver", vancouver);
        City calgary = new City("Calgary"); cities.put("Calgary", calgary);
        City winnipeg = new City("Winnipeg"); cities.put("Winnipeg", winnipeg);
        City saultStMarie = new City("Sault St. Marie"); cities.put("Sault St. Marie", saultStMarie);
        City montreal = new City("Montreal"); cities.put("Montreal", montreal);
        City seattle = new City("Seattle"); cities.put("Seattle", seattle);
        City helena = new City("Helena"); cities.put("Helena", helena);
        City duluth = new City("Duluth"); cities.put("Duluth", duluth);
        City toronto = new City("Toronto"); cities.put("Toronto", toronto);
        City boston = new City("Boston"); cities.put("Boston", boston);
        City newYork = new City("New York"); cities.put("New York", newYork);
        City pittsburgh = new City("Pittsburgh"); cities.put("Pittsburgh", pittsburgh);
        City chicago = new City("Chicago"); cities.put("Chicago", chicago);
        City omaha = new City("Omaha"); cities.put("Omaha", omaha);
        City portland = new City("Portland"); cities.put("Portland", portland);
        City washington = new City("Washington"); cities.put("Washington", washington);
        City raleigh = new City("Raleigh"); cities.put("Raleigh", raleigh);
        City nashville = new City("Nashville"); cities.put("Nashville", nashville);
        City saintLouis = new City("Saint Louis"); cities.put("Saint Louis", saintLouis);
        City kansasCity= new City("Kansas City"); cities.put("Kansas City", kansasCity);
        City denver = new City("Denver"); cities.put("Denver", denver);
        City saltLakeCity = new City("Salt Lake City"); cities.put("Salt Lake City", saltLakeCity);
        City sanFrancisco = new City("San Francisco"); cities.put("San Francisco", sanFrancisco);
        City lasVegas = new City("Las Vegas"); cities.put("Las Vegas", lasVegas);
        City santaFe = new City("Santa Fe"); cities.put("Santa Fe", santaFe);
        City oklahomaCity = new City("Oklahoma City"); cities.put("Oklahoma City", oklahomaCity);
        City littleRock = new City("Little Rock"); cities.put("Little Rock", littleRock);
        City atlanta = new City("Atlanta"); cities.put("Atlanta", atlanta);
        City charleston = new City("Charleston"); cities.put("Charleston", charleston);
        City losAngeles = new City("Los Angeles"); cities.put("Los Angeles", losAngeles);
        City phoenix = new City("Phoenix"); cities.put("Phoenix", phoenix);
        City elPaso = new City("El Paso"); cities.put("El Paso", elPaso);
        City dallas = new City("Dallas"); cities.put("Dallas", dallas);
        City houston = new City("Houston"); cities.put("Houston", houston);
        City newOrleans = new City("New Orleans"); cities.put("New Orleans", newOrleans);
        City miami = new City("Miami"); cities.put("Miami", miami);

        HashMap<String, Route> routes = new HashMap<>();//routes for Vancouver
        routes.put("Calgary", new Route(calgary, 3, "Grey"));
        routes.put("Seattle1", new Route(seattle, 1, "Grey"));
        routes.put("Seattle2", new Route(seattle, 1, "Grey"));
        vancouver.setRoutes(routes);

        routes = new HashMap<>();//routes for Calgary
        routes.put("Vancouver", new Route(vancouver, 3, "Grey"));
        routes.put("Seattle", new Route(seattle, 4, "Grey"));
        routes.put("Helena", new Route(helena, 4, "Grey"));
        routes.put("Winnipeg", new Route(winnipeg, 6, "White"));
        calgary.setRoutes(routes);

        routes = new HashMap<>();//routes for Winnipeg
        routes.put("Calgary", new Route(calgary, 6, "White"));
        routes.put("Helena", new Route(helena, 4, "Blue"));
        routes.put("Duluth", new Route(duluth, 4, "Black"));
        routes.put("Sault St. Marie", new Route(saultStMarie, 6, "Grey"));
        winnipeg.setRoutes(routes);

        routes = new HashMap<>();//routes for Sault St. Marie
        routes.put("Winnipeg", new Route(winnipeg, 6, "Grey"));
        routes.put("Duluth", new Route(duluth, 3, "Grey"));
        routes.put("Toronto", new Route(toronto, 2, "Grey"));
        routes.put("Montreal", new Route(montreal, 5, "Black"));
        saultStMarie.setRoutes(routes);

        routes = new HashMap<>();//routes for Montreal
        routes.put("Sault St. Marie", new Route(saultStMarie, 5, "Black"));
        routes.put("Toronto", new Route(toronto, 3, "Grey"));
        routes.put("New York", new Route(newYork, 3, "Blue"));
        routes.put("Boston1", new Route(boston, 2, "Grey"));
        routes.put("Boston2", new Route(boston, 2, "Grey"));
        montreal.setRoutes(routes);

        routes = new HashMap<>();//routes for Seattle
        routes.put("Calgary", new Route(calgary, 4, "Grey"));
        routes.put("Helena", new Route(helena, 6, "Yellow"));
        routes.put("Portland1", new Route(portland, 1, "Grey"));
        routes.put("Portland2", new Route(portland, 1, "Grey"));
        routes.put("Vancouver1", new Route(vancouver, 1, "Grey"));
        routes.put("Vancouver2", new Route(vancouver, 1, "Grey"));
        seattle.setRoutes(routes);

        routes = new HashMap<>(); //routes for Helena
        routes.put("Calgary", new Route(calgary, 4, "Grey"));
        routes.put("Winnipeg", new Route(winnipeg, 4, "Blue"));
        routes.put("Duluth", new Route(duluth, 6, "Orange"));
        routes.put("Omaha", new Route(omaha, 4, "Red"));
        routes.put("Denver", new Route(denver, 4, "Green"));
        routes.put("Salt Lake City", new Route(saltLakeCity, 3, "Purple"));
        routes.put("Seattle", new Route(seattle, 6, "Yellow"));
        helena.setRoutes(routes);

        routes = new HashMap<>(); //routes for Portland
        routes.put("Seattle1", new Route(seattle, 1, "Grey"));
        routes.put("Seattle2", new Route(seattle, 1, "Grey"));
        routes.put("Salt Lake City", new Route(saltLakeCity, 6, "Blue"));
        routes.put("San Francisco1", new Route(sanFrancisco, 5, "Purple"));
        routes.put("San Francisco2", new Route(sanFrancisco, 5, "Green"));
        portland.setRoutes(routes);

        routes = new HashMap<>(); //routes for San Francisco
        routes.put("Portland1", new Route(portland, 5, "Purple"));
        routes.put("Portland2", new Route(portland, 5, "Green"));
        routes.put("Salt Lake City1", new Route(saltLakeCity, 5, "Orange"));
        routes.put("Salt Lake City2", new Route(saltLakeCity, 5, "White"));
        routes.put("Los Angeles1", new Route(losAngeles, 3, "Purple"));
        routes.put("Los Angeles2", new Route(losAngeles, 3, "Yellow"));
        sanFrancisco.setRoutes(routes);

        routes = new HashMap<>(); //routes for los angeles
        routes.put("San Francisco1", new Route(sanFrancisco, 3, "Purple"));
        routes.put("San Francisco2", new Route(sanFrancisco, 3, "Yellow"));
        routes.put("Las Vegas", new Route(lasVegas, 2, "Grey"));
        routes.put("Phoenix", new Route(phoenix, 3, "Grey"));
        routes.put("El Paso", new Route(elPaso, 6, "Black"));
        losAngeles.setRoutes(routes);

        routes = new HashMap<>(); //routes for salt lake city
        routes.put("Portland", new Route(portland, 6, "Blue"));
        routes.put("Helena", new Route(helena, 3, "Purple"));
        routes.put("Denver1", new Route(denver, 3, "Red"));
        routes.put("Denver2", new Route(denver, 3, "Yellow"));
        routes.put("Las Vegas", new Route(lasVegas, 3, "Orange"));
        routes.put("San Francisco1", new Route(sanFrancisco, 5, "Orange"));
        routes.put("San Francisco2", new Route(sanFrancisco, 5, "White"));
        saltLakeCity.setRoutes(routes);

        routes = new HashMap<>(); //routes for Las Vegas
        routes.put("Salt Lake City", new Route(saltLakeCity, 3, "Orange"));
        routes.put("Los Angeles", new Route(losAngeles, 2, "Grey"));
        lasVegas.setRoutes(routes);

        routes = new HashMap<>(); //routes for Phoenix
        routes.put("Los Angeles", new Route(losAngeles, 3, "Grey"));
        routes.put("Denver", new Route(denver, 5, "White"));
        routes.put("Santa Fe", new Route(santaFe, 3, "Grey"));
        routes.put("El Paso", new Route(elPaso, 3, "Grey"));
        phoenix.setRoutes(routes);

        routes = new HashMap<>(); //routes for El Paso
        routes.put("Los Angeles", new Route(losAngeles, 6, "Black"));
        routes.put("Phoenix", new Route(phoenix, 3, "Grey"));
        routes.put("Santa Fe", new Route(santaFe, 2, "Grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 5, "Yellow"));
        routes.put("Dallas", new Route(dallas, 4, "Red"));
        routes.put("Houston", new Route(houston, 6, "Green"));
        elPaso.setRoutes(routes);

        routes = new HashMap<>(); //routes for Santa Fe
        routes.put("Phoenix", new Route(phoenix, 3, "Grey"));
        routes.put("Denver", new Route(denver, 2, "Grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 3, "Blue"));
        routes.put("El Paso", new Route(elPaso, 2, "Grey"));
        santaFe.setRoutes(routes);

        routes = new HashMap<>(); //routes for Denver
        routes.put("Helena", new Route(helena, 4, "Green"));
        routes.put("Salt Lake City1", new Route(saltLakeCity, 3, "Red"));
        routes.put("Salt Lake City2", new Route(saltLakeCity, 3, "Yellow"));
        routes.put("Phoenix", new Route(phoenix, 5, "White"));
        routes.put("Santa Fe", new Route(santaFe, 2, "Grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 4, "Red"));
        routes.put("Kansas City1", new Route(kansasCity, 4, "Orange"));
        routes.put("Kansas City2", new Route(kansasCity, 4, "Black"));
        routes.put("Omaha", new Route(omaha, 4, "Purple"));
        denver.setRoutes(routes);

        routes = new HashMap<>(); //routes for Omaha
        routes.put("Helena", new Route(helena, 5, "Red"));
        routes.put("Duluth1", new Route(duluth, 1, "Grey"));
        routes.put("Duluth2", new Route(duluth, 1, "Grey"));
        routes.put("Chicago", new Route(chicago, 4, "Blue"));
        routes.put("Kansas City1", new Route(kansasCity, 1, "Grey"));
        routes.put("Kansas City2", new Route(kansasCity, 1, "Grey"));
        routes.put("Denver", new Route(denver, 4, "Purple"));
        omaha.setRoutes(routes);

        routes = new HashMap<>(); //routes for Duluth
        routes.put("Helena", new Route(helena, 6, "Orange"));
        routes.put("Winnipeg", new Route(winnipeg, 4, "Black"));
        routes.put("Sault St. Marie", new Route(saultStMarie, 3, "Grey"));
        routes.put("Toronto", new Route(toronto, 6, "Purple"));
        routes.put("Chicago", new Route(chicago, 3, "Red"));
        routes.put("Omaha1", new Route(omaha, 1, "Grey"));
        routes.put("Omaha2", new Route(omaha, 1, "Grey"));
        duluth.setRoutes(routes);

        routes = new HashMap<>(); //routes for Kansas City
        routes.put("Omaha1", new Route(omaha, 1, "Grey"));
        routes.put("Omaha2", new Route(omaha, 1, "Grey"));
        routes.put("Saint Louis1", new Route(saintLouis, 2, "Blue"));
        routes.put("Saint Louis2", new Route(saintLouis, 2, "Purple"));
        routes.put("Oklahoma City1", new Route(oklahomaCity, 2, "Grey"));
        routes.put("Oklahoma City2", new Route(oklahomaCity, 2, "Grey"));
        routes.put("Denver1", new Route(denver, 5, "Orange"));
        routes.put("Denver2", new Route(denver, 5, "Black"));
        kansasCity.setRoutes(routes);

        routes = new HashMap<>(); //routes for Oklahoma City
        routes.put("Kansas City1", new Route(kansasCity, 2, "Grey"));
        routes.put("Kansas City 2", new Route(kansasCity, 2, "Grey"));
        routes.put("Little Rock", new Route(littleRock, 2, "Grey"));
        routes.put("Dallas1", new Route(dallas, 2, "Grey"));
        routes.put("Dallas2", new Route(dallas, 2, "Grey"));
        routes.put("El Paso", new Route(elPaso, 5, "Yellow"));
        routes.put("Santa Fe", new Route(santaFe, 3, "Blue"));
        routes.put("Denver", new Route(denver, 4, "Red"));
        oklahomaCity.setRoutes(routes);

        routes = new HashMap<>(); //routes for Dallas
        routes.put("El Paso", new Route(elPaso, 4, "Red"));
        routes.put("Oklahoma City1", new Route(oklahomaCity, 2, "Grey"));
        routes.put("Oklahoma City2", new Route(oklahomaCity, 2, "Grey"));
        routes.put("Little Rock", new Route(littleRock, 2, "Grey"));
        routes.put("Houston1", new Route(houston, 1, "Grey"));
        routes.put("Houston2", new Route(houston, 1, "Grey"));
        dallas.setRoutes(routes);

        routes = new HashMap<>(); //routes for Houston
        routes.put("Dallas1", new Route(dallas, 1, "Grey"));
        routes.put("Dallas2", new Route(dallas, 1, "Grey"));
        routes.put("New Orleans", new Route(newOrleans, 2, "Grey"));
        routes.put("El Paso", new Route(elPaso, 6, "Green"));
        houston.setRoutes(routes);

        routes = new HashMap<>(); //rotues for New Orleans
        routes.put("Houston", new Route(houston, 2, "Grey"));
        routes.put("Little Rock", new Route(littleRock, 3, "Green"));
        routes.put("Atlanta1", new Route(atlanta, 4, "Yellow"));
        routes.put("Atlanta2", new Route(atlanta, 4, "Orange"));
        routes.put("Miami", new Route(miami, 6, "Red"));
        newOrleans.setRoutes(routes);

        routes = new HashMap<>(); //routes for Little Rock
        routes.put("Dallas", new Route(dallas, 2, "Grey"));
        routes.put("Oklahoma City", new Route(oklahomaCity, 2, "Grey"));
        routes.put("Saint Louis", new Route(saintLouis, 2, "Grey"));
        routes.put("Nashville", new Route(nashville, 3, "White"));
        routes.put("New Orleans", new Route(newOrleans, 3, "Green"));
        littleRock.setRoutes(routes);

        routes = new HashMap<>(); //routes for Saint Louis
        routes.put("Little Rock", new Route(littleRock, 2, "Grey"));
        routes.put("Kansas City1", new Route(kansasCity, 2, "Blue"));
        routes.put("Kansas City2", new Route(kansasCity, 2, "Purple"));
        routes.put("Chicago1", new Route(chicago, 2, "Green"));
        routes.put("Chicago2", new Route(chicago, 2, "White"));
        routes.put("Pittsburgh", new Route(pittsburgh, 5, "Green"));
        routes.put("Nashville", new Route(nashville, 2, "Grey"));
        saintLouis.setRoutes(routes);

        routes = new HashMap<>(); //routes for Chicago
        routes.put("Saint Louis1", new Route(saintLouis, 2, "Green"));
        routes.put("Saint Louis2", new Route(saintLouis, 2, "White"));
        routes.put("Omaha", new Route(omaha, 4, "Blue"));
        routes.put("Duluth", new Route(duluth, 3, "Red"));
        routes.put("Toronto", new Route(toronto, 4, "White"));
        routes.put("Pittsburgh1", new Route(pittsburgh, 3, "Orange"));
        routes.put("Pittsburgh2", new Route(pittsburgh, 3, "Black"));
        chicago.setRoutes(routes);

        routes = new HashMap<>(); //routes for Toronto
        routes.put("Sault St. Marie", new Route(saultStMarie, 2, "Grey"));
        routes.put("Montreal", new Route(montreal, 3, "Grey"));
        routes.put("Pittsburgh", new Route(pittsburgh, 2, "Grey"));
        routes.put("Phoenix1", new Route(phoenix, 3, "Grey"));
        routes.put("Chicago", new Route(chicago, 4, "White"));
        routes.put("Duluth", new Route(duluth, 6, "Purple"));
        routes.put("Phoenix2", new Route(phoenix, 3, "Grey"));
        toronto.setRoutes(routes);

        routes = new HashMap<>(); //routes for Pittsburgh
        routes.put("Chicago1", new Route(chicago, 3, "Black"));
        routes.put("Chicago2", new Route(chicago, 3, "Orange"));
        routes.put("Toronto", new Route(toronto, 2, "Grey"));
        routes.put("New York1", new Route(newYork, 2, "White"));
        routes.put("New York2", new Route(newYork, 2, "Green"));
        routes.put("Washington", new Route(washington, 2, "Grey"));
        routes.put("Raleigh", new Route(raleigh, 2, "Grey"));
        routes.put("Nashville", new Route(nashville, 4, "Yellow"));
        routes.put("Saint Louis", new Route(saintLouis, 5, "Green"));
        pittsburgh.setRoutes(routes);

        routes = new HashMap<>(); //routes for Nashville
        routes.put("Saint Louis", new Route(saintLouis, 2, "Grey"));
        routes.put("Pittsburgh", new Route(pittsburgh, 4, "Yellow"));
        routes.put("Raleigh", new Route(raleigh, 3, "Black"));
        routes.put("Atlanta", new Route(atlanta, 1, "Grey"));
        routes.put("Little Rock", new Route(littleRock, 3, "White"));
        nashville.setRoutes(routes);

        routes = new HashMap<>(); //routes for Atlanta
        routes.put("Nashville", new Route(nashville, 1, "Grey"));
        routes.put("Raleigh1", new Route(raleigh, 2, "Grey"));
        routes.put("Raleigh2", new Route(raleigh, 2, "Grey"));
        routes.put("Charleston", new Route(charleston, 2, "Grey"));
        routes.put("Miami", new Route(miami, 5, "Blue"));
        routes.put("New Orleans1", new Route(newOrleans, 4, "Yellow"));
        routes.put("New Orleans2", new Route(newOrleans, 4, "Orange"));
        routes.put("Phoenix", new Route(phoenix, 3, "Grey"));
        atlanta.setRoutes(routes);

        routes = new HashMap<>(); //routes for Miami
        routes.put("New Orleans", new Route(newOrleans, 6, "Red"));
        routes.put("Atlanta", new Route(atlanta, 5, "Blue"));
        routes.put("Charleston", new Route(charleston, 4, "Purple"));
        miami.setRoutes(routes);

        routes = new HashMap<>(); //routes for Charleston
        routes.put("Miami", new Route(miami, 4, "Purple"));
        routes.put("Atlanta", new Route(atlanta, 2, "Grey"));
        routes.put("Raleigh", new Route(raleigh, 2, "Grey"));
        charleston.setRoutes(routes);

        routes = new HashMap<>(); //routes for Raleigh
        routes.put("Charleston", new Route(charleston, 2, "Grey"));
        routes.put("Atlanta1", new Route(atlanta, 2, "Grey"));
        routes.put("Atlanta2", new Route(atlanta, 2, "Grey"));
        routes.put("Nashville", new Route(nashville, 3, "Black"));
        routes.put("Pittsburgh", new Route(pittsburgh, 2, "Grey"));
        routes.put("Washington1", new Route(washington, 2, "Grey"));
        routes.put("Washington2", new Route(washington, 2, "Grey"));
        raleigh.setRoutes(routes);

        routes = new HashMap<>(); //routes for Washington
        routes.put("Raleigh1", new Route(raleigh, 2, "Grey"));
        routes.put("Raleigh2", new Route(raleigh, 2, "Grey"));
        routes.put("Pittsburgh", new Route(pittsburgh, 2, "Grey"));
        routes.put("New York1", new Route(newYork, 2, "Orange"));
        routes.put("New York2", new Route(newYork, 2, "Black"));
        washington.setRoutes(routes);

        routes = new HashMap<>(); //routes for New York
        routes.put("Washington1", new Route(washington, 2, "Orange"));
        routes.put("Washington2", new Route(washington, 2, "Black"));
        routes.put("Pittsburgh1", new Route(pittsburgh, 2, "White"));
        routes.put("Pittsburgh2", new Route(pittsburgh, 2, "Green"));
        routes.put("Montreal", new Route(montreal, 3, "Blue"));
        routes.put("Boston1", new Route(boston, 2, "Yellow"));
        routes.put("Boston2", new Route(boston, 2, "Red"));
        newYork.setRoutes(routes);

        routes = new HashMap<>(); //routes for Boston
        routes.put("New York1", new Route(newYork, 2, "Red"));
        routes.put("New York2", new Route(newYork, 2, "Yellow"));
        routes.put("Montreal1", new Route(montreal, 2, "Grey"));
        routes.put("Montreal2", new Route(montreal, 2, "Grey"));
        boston.setRoutes(routes);
    }

    /**
     * This method check whether two cities are connected
     * @param c1 the fist city
     * @param c2 the second city
     * @return whether the two cities are connected
     */
    //TODO finish this method for the Route Cards
    public boolean isConnected(City c1, City c2, ArrayList<City> citiesChecked, int playerNum){
        if(c1 == c2)
            return true;
        citiesChecked.add(c1);
        ArrayList<Route> routes = new ArrayList<>();
        for (Route r : c1.getRoutes().values()){
            if(r.getPlayerNum() == playerNum && !citiesChecked.contains(r.city))
                routes.add(r);
        }
        if(routes.size()==1)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum);
        else if(routes.size()==2)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum);
        else if(routes.size()==3)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum);
        else if(routes.size()==4)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(3).city, c2, citiesChecked, playerNum);
        else if(routes.size()==5)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(3).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(4).city, c2, citiesChecked, playerNum);
        else if(routes.size()==6)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(3).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(4).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(5).city, c2, citiesChecked, playerNum);
        else if(routes.size()==7)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(3).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(4).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(5).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(6).city, c2, citiesChecked, playerNum);
        else if(routes.size()==8)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(3).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(4).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(5).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(6).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(7).city, c2, citiesChecked, playerNum);
        else if(routes.size()==9)
            return isConnected(routes.get(0).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(1).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(2).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(3).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(4).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(5).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(6).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(7).city, c2, citiesChecked, playerNum) ||
                    isConnected(routes.get(8).city, c2, citiesChecked, playerNum);
        return false;//the greatest number of routes coming from one city is 9.
    }

    public HashMap<String, City> getCities() {
        return cities;
    }
}
