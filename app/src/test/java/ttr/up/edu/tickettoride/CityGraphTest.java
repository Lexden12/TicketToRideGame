package ttr.up.edu.tickettoride;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CityGraphTest {

    @Test
    public void isConnected() {
        CityGraph cg = new CityGraph();
        cg.cities.get("Portland").getRoutes().get("Seattle1").setPlayerNum(0);
        cg.cities.get("Seattle").getRoutes().get("Portland1").setPlayerNum(0);
        cg.cities.get("Portland").getRoutes().get("Salt Lake City").setPlayerNum(0);
        cg.cities.get("Salt Lake City").getRoutes().get("Portland").setPlayerNum(0);
        cg.cities.get("Salt Lake City").getRoutes().get("Helena").setPlayerNum(0);
        cg.cities.get("Helena").getRoutes().get("Salt Lake City").setPlayerNum(0);
        cg.cities.get("Seattle").getRoutes().get("Helena").setPlayerNum(0);
        cg.cities.get("Helena").getRoutes().get("Seattle").setPlayerNum(0);
        cg.cities.get("Helena").getRoutes().get("Duluth").setPlayerNum(0);
        cg.cities.get("Duluth").getRoutes().get("Helena").setPlayerNum(0);
        cg.cities.get("Duluth").getRoutes().get("Toronto").setPlayerNum(0);
        cg.cities.get("Toronto").getRoutes().get("Duluth").setPlayerNum(0);
        cg.cities.get("Duluth").getRoutes().get("Omaha1").setPlayerNum(0);
        cg.cities.get("Omaha").getRoutes().get("Duluth1").setPlayerNum(0);
        cg.cities.get("Omaha").getRoutes().get("Denver").setPlayerNum(0);
        cg.cities.get("Denver").getRoutes().get("Omaha").setPlayerNum(0);
        cg.cities.get("Denver").getRoutes().get("Salt Lake City1").setPlayerNum(0);
        cg.cities.get("Salt Lake City").getRoutes().get("Denver1").setPlayerNum(0);
        assertTrue(cg.isConnected(cg.cities.get("Portland"), cg.cities.get("Toronto"), new ArrayList<City>(), 0));
        assertTrue(cg.isConnected(cg.cities.get("Portland"), cg.cities.get("Omaha"), new ArrayList<City>(), 0));
        assertFalse(cg.isConnected(cg.cities.get("Portland"), cg.cities.get("Chicago"), new ArrayList<City>(), 0));
        assertTrue(cg.isConnected(cg.cities.get("Toronto"), cg.cities.get("Toronto"), new ArrayList<City>(), 0));
        assertTrue(cg.isConnected(cg.cities.get("Toronto"), cg.cities.get("Portland"), new ArrayList<City>(), 0));
        assertTrue(cg.isConnected(cg.cities.get("Omaha"), cg.cities.get("Toronto"), new ArrayList<City>(), 0));
        assertTrue(cg.isConnected(cg.cities.get("Omaha"), cg.cities.get("Helena"), new ArrayList<City>(), 0));
        assertFalse(cg.isConnected(cg.cities.get("Boston"), cg.cities.get("Atlanta"), new ArrayList<City>(), 0));
        int scores = 0;
        ArrayList<Route> routes = new ArrayList<>();
        for (City c : cg.getCities().values()) {
            for (String s : c.getRoutes().keySet()) {
                Route r = c.getRoutes().get(s);
                if (r.getPlayerNum() == 0) {
                    if (r.getLength() == 1)
                        scores += 1;
                    else if (r.getLength() == 2)
                        scores += 2;
                    else if (r.getLength() == 3)
                        scores += 4;
                    else if (r.getLength() == 4)
                        scores += 7;
                    else if (r.getLength() == 5)
                        scores += 10;
                    else if (r.getLength() == 6)
                        scores += 15;
                    r.setPlayerNum(-1);
                    City c2 = r.getCity();
                    Route rReverse;
                    if (s.contains("1"))
                        rReverse = c2.getRoutes().get(c.getName() + "1");
                    else if (s.contains("2"))
                        rReverse = c2.getRoutes().get(c.getName() + "2");
                    else
                        rReverse = c2.getRoutes().get(c.getName());
                    rReverse.setPlayerNum(-1);
                    assertFalse(routes.contains(r));
                    assertFalse(routes.contains(rReverse));
                    routes.add(r);
                    routes.add(rReverse);
                }
            }
        }
    }
}