package ttr.up.edu.tickettoride;

import org.junit.Test;

import java.util.ArrayList;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.infoMsg.GameState;

import static org.junit.Assert.*;

public class TTR_LocalGameTest {

    /**
     * @author Alex Schendel
     * Basic test to ensure scoring works as intended
     * DOES NOT WORK (TEST DOES NOT ALLOW FOR ALL METHODS TO RUN)
     */
    @Test
    public void checkIfGameOver() {
        TTR_LocalGame lg = new TTR_LocalGame();
        GamePlayer[] players = new GamePlayer[2];
        players[0] = new TTR_GameHumanPlayer("Lexden", R.layout.human_player_display);
        players[1] = new TTR_GameComputerPlayer("Computer");
        lg.start(players);
        TTR_GameState gameState = lg.getGameState();
        ArrayList<PlayerHand> playerHands = gameState.getPlayerHands();
        playerHands.get(0).setTrains(0);
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
                    routeCards.add(gameState.getRouteDeck().cards.remove(i));
            }
        }
        if(!has2){
            for(int i = 0; i < gameState.getRouteDeck().cards.size(); i++){
                if(gameState.getRouteDeck().cards.get(i).getName().equals("Seattle - Los Angeles"))
                    routeCards.add(gameState.getRouteDeck().cards.remove(i));
            }
        }
        if(!has3){
            for(int i = 0; i < gameState.getRouteDeck().cards.size(); i++){
                if(gameState.getRouteDeck().cards.get(i).getName().equals("Montreal - Atlanta"))
                    routeCards.add(gameState.getRouteDeck().cards.remove(i));
            }
        }
        playerHands.get(0).setRouteCards(routeCards);
        CityGraph cg = gameState.getGraph();
        cg.cities.get("Seattle").routes.get("Helena").setPlayerNum(0);
        cg.cities.get("Helena").routes.get("Seattle").setPlayerNum(0);
        cg.cities.get("Helena").routes.get("Salt Lake City").setPlayerNum(0);
        cg.cities.get("Salt Lake City").routes.get("Helena").setPlayerNum(0);
        cg.cities.get("Salt Lake City").routes.get("Las Vegas").setPlayerNum(0);
        cg.cities.get("Las Vegas").routes.get("Salt Lake City").setPlayerNum(0);
        cg.cities.get("Las Vegas").routes.get("Los Angeles").setPlayerNum(0);
        cg.cities.get("Los Angeles").routes.get("Las Vegas").setPlayerNum(0);
        String end = lg.checkIfGameOver();
        while(end == null){
            gameState.endTurn();
        }
        assertTrue(lg.checkIfGameOver().contains("Player 0 wins!\nScores:\nPlayer 0:\t33"));
    }
}