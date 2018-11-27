package ttr.up.edu.tickettoride;

import java.util.ArrayList;
import java.util.Collections;
//todo change methods back to private after unit testing
/**
 * class Dijkstra
 *
 * a class to calculate the minimum spanning path between two cities
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class Dijkstra {
    CityGraph graph;
    ArrayList<String> queue;
    ArrayList<String> path;
    Boolean timeout;
    int playerNumber;


    public Dijkstra(CityGraph graph, String startCity, String endCity, int playerNumber) {
        timeout = false;
        this.playerNumber = playerNumber;
        this.graph = graph;
        queue = new ArrayList<>(graph.getCities().keySet());
        path = new ArrayList<>();
        initializeQueue(startCity);
        calculateDGraph();
        determinePath(endCity);
    }

    /**
     * Get the calculated minimum spanning path from the start to end city
     * @return the minimum spanning path from the start to end city
     */
    public ArrayList<String> getPath(){
        if (timeout) return null;
        return path;
    }

    /**
     * Put the startCity at the front of the queue
     * @param startCity the start location of the minimum spanning path
     */
    public void initializeQueue(String startCity){
         int pos = queue.indexOf(startCity);
        if (pos > 0){
            queue.remove(pos);
            queue.add(0, startCity);
            graph.getCities().get(startCity).setCost(0);
        }
    }

    /**
     * Generate the Dijkstra's graph (least cost path)
     * Only unclaimed paths are used in the calculation
     */
    public void calculateDGraph(){
        int size = queue.size();
        for (int i = 0; i<size; i++){
            //get the city at the front of queue
            String cityName = queue.get(0);
            queue.remove(0);
            City city = graph.getCities().get(cityName);
            //iterate through city edges and update costs
                for (Route r : city.getRoutes().values()){
                    City adjacentCity = r.getCity();
                    if (city.getCost() + r.getLength() < adjacentCity.getCost() && (r.getPlayerNum() == -1 || r.getPlayerNum() == this.playerNumber)){
                        adjacentCity.setCost(r.getLength()+city.getCost());
                        adjacentCity.setParent(city.getName());
                    }
                }
            //update the queue positions to reflect updated costs
            updateQueue();
        }
    }

    /**
     * Sorts the queue by the current order of cost (selection sort)
     */
    public void updateQueue(){
        String c1;
        String c2;
        if (queue.size() > 0) {
            for (int i = 0; i < queue.size(); i++) {
                c1 = queue.get(i);
                for (int b = i+1; b < queue.size(); b++) {
                    c2 = queue.get(b);
                    if (graph.getCities().get(c1).getCost() > graph.getCities().get(c2).getCost()) {
                        //swap the items
                        Collections.swap(queue, i, b);
                    }
                }
            }
        }
    }

    /**
     * Find the minimum spanning path to the end City
     * @param endCity the end city of the path
     */
    public void determinePath(String endCity){
        City currentCity = graph.getCities().get(endCity);
        int maxIterations = (new ArrayList<>(graph.getCities().keySet())).size();
        int currentIterations = 0;

        while (currentCity != null){
            if (currentIterations >= maxIterations) { //handles case where it is impossible to reach destination
                timeout = true;
                return;
            }
            path.add(currentCity.getName());
            currentCity = graph.getCities().get(currentCity.getParent());
            currentIterations++;
        }
    }

    public ArrayList<String> getQueue() {
        return queue;
    }
}
