/**
 * class DijsktraTest
 *
 * a class to test Dijkstra
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version November 2018
 *
 */

package ttr.up.edu.tickettoride;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DijkstraTest {

    @Test //@author Cameron
    public void calculatedPath() {
        //setup
        CityGraph graph = new CityGraph();
        Dijkstra dij = new Dijkstra(graph, "Boston", "Omaha", 1);
        ArrayList<String> path = dij.getPath();

        //check each item in the path
        assertTrue(path.get(0).equals("Omaha"));
        assertTrue(path.get(1).equals("Chicago"));
        assertTrue(path.get(2).equals("Pittsburgh"));
        assertTrue(path.get(3).equals("New York"));
        assertTrue(path.get(4).equals("Boston"));
    }

    @Test //@author Cameron
    public void checkQueues() {
        //setup
        CityGraph graph = new CityGraph();
        Dijkstra dij = new Dijkstra(graph, "Boston", "Omaha", 1);

        //check that all items in the queue were emptied
        ArrayList<String> queue = dij.getQueue();
        assertEquals(queue.size(), 0);

        //check that the path is length five
        ArrayList<String> path = dij.getPath();
        assertEquals(path.size(), 5);
    }

    @Test
    public void calculateDGraph() {
    }

    @Test
    public void updateQueue() {
    }

    @Test
    public void determinePath() {
    }
}