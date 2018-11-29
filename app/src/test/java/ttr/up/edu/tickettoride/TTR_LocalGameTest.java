package ttr.up.edu.tickettoride;

import org.junit.Test;

import java.util.ArrayList;

import ttr.up.edu.game.infoMsg.GameState;

import static org.junit.Assert.*;

public class TTR_LocalGameTest {

    /**
     * @author Alex Schendel
     * Basic test to ensure scoring works as intended
     */
    @Test
    public void checkIfGameOver() {
        TTR_LocalGame lg = new TTR_LocalGame();
        TTR_GameState gameState = lg.getGameState();
        gameState.getPlayerHands().get(0).setTrains(3);
        ArrayList<RouteCard> routeCards = gameState.getPlayerHands().get(0).getRouteCards();
        for(RouteCard rc:routeCards){
            if(!rc.getName().equals("Helena - Los Angeles") && !rc.getName().equals("Seattle - Los Angeles")
                    && !rc.getName().equals("Montreal - Atlanta")){
                routeCards.remove(rc);
            }
        }
        boolean has1, has2, has3;
        has1 = has2 = has3 = false;
        for(RouteCard rc:routeCards) {
            if(rc.getName().equals("Helena - Los Angeles"))
                has1 = true;
            else if(rc.getName().equals("Seattle - Los Angeles"))
                has2 = true;
            else if(rc.getName().equals("Montreal - Atlanta"))
                has3 = true;
        }
        if(!has1){
            for(int i = 0; i < gameState.getRouteDeck().cards.size(); i++){
                if(gameState.getRouteDeck().cards.get(i).getName().equals("Helena - Los Angeles"))
                    routeCards.add(gameState.getRouteDeck().cards.remove());
            }
        }
    }
}