/**
 * class TTR_SmartComputerPlayer
 * <p>
 * a class to represent a GameComputerPlayer
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version November 2018
 */
package ttr.up.edu.tickettoride;

import java.util.ArrayList;

import ttr.up.edu.game.GameComputerPlayer;
import ttr.up.edu.game.infoMsg.GameInfo;

public class TTR_SmartComputerPlayer extends GameComputerPlayer {
    /**
     * constructor
     *
     * @param name the player's name (e.g., "John")
     */
    public TTR_SmartComputerPlayer(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof TTR_GameState) {
            TTR_GameState state = (TTR_GameState) info;
            if (!(state.getCurrentPlayer() == getPlayerNum())) return;
            sleep(500);

            //check if there are any route cards left, if not draw one
            boolean remainingRoutes = false;
            for(RouteCard rc:state.getPlayerHands().get(playerNum).getRouteCards()){
                String[] cities = rc.getName().split(" - ");
                City c1 = state.getGraph().cities.get(cities[0]);
                City c2 = state.getGraph().cities.get(cities[1]);
                if(!state.getGraph().isConnected(c1, c2, new ArrayList<City>(), playerNum)) {
                    remainingRoutes = true;
                    break;
                }
            }
            if(!remainingRoutes)
                game.sendAction(new DrawRouteDeckGameAction(this));

            //find the shortest path
            //if any of the routes in the path can be claimed, claim it
            Dijkstra dij;
            for (Card c : state.getPlayerHands().get(this.getPlayerNum()).getRouteCards()) {
                String[] cities = c.getName().split(" - ");
                dij = new Dijkstra(state.getGraph(), cities[0], cities[1], getPlayerNum());
                //attempt to claim any of the shortest routes
                ArrayList<String> path = dij.getPath();
                if (path != null) {
                    String route = null;
                    for (int i = 0; i < path.size() - 1; i++) {
                        route = path.get(i) + "<->" + path.get(i + 1);
                        game.sendAction(new ClaimRouteGameAction(this, route));
                        route = path.get(i) + "<->" + path.get(i + 1) + "1";
                        game.sendAction(new ClaimRouteGameAction(this, route));
                        route = path.get(i) + "<->" + path.get(i + 1) + "2";
                        game.sendAction(new ClaimRouteGameAction(this, route));
                    }
                }
            }

            //if other options fail, draw a train card
            game.sendAction(new DrawTrainDeckGameAction(this));
            return;

        }
    }

    //getter
    public int getPlayerNum() {
        return this.playerNum;
    }
}
