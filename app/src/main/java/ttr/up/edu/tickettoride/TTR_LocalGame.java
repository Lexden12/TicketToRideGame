package ttr.up.edu.tickettoride;

import android.content.Context;

import java.util.ArrayList;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class TTR_LocalGame
 *
 * is a class to extend LocalGame to implement a playable action-based game in the future.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TTR_LocalGame extends LocalGame {

    private TTR_GameState gameState;
    private int numPlayers;


    public TTR_LocalGame() {
        gameState = new TTR_GameState(numPlayers);
    }

    @Override
    public void start(GamePlayer[] players) {
        numPlayers = players.length;
        ArrayList<PlayerHand> hands = new ArrayList<>();
        for(int i=0;i<numPlayers;i++){
            hands.add(new PlayerHand(getAssignedPlayerColor(i)));
        }
        gameState.setPlayerHands(hands);
        super.start(players);
    }


    @Override
    public String toString() {
        /*
        StringBuilder out = new StringBuilder();
        out.append("Train Deck: \n");
        out.append(trainDeck.toString());
        out.append("BoardRoute Deck: \n");
        for (int i = 0; i< playerHands.size(); i++) {
            out.append("PlayerHand "+i+": ");
            out.append(playerHands.toString());
        }
        out.append("Board: \n");
        out.append(board.toString());
        out.append("Current player: "+ currentPlayer + "\n");
        return out.toString();
        */
        String str = "";
        return str;
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        p.sendInfo(gameState);//TODO send a limited gameState
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return this.gameState.getCurrentPlayer() == playerIdx;
    }

    @Override
    protected String checkIfGameOver() {
        if(gameState.getTurnsLeft() != 0) return null;
        int[] scores = new int[numPlayers];
        for(int i = 0; i < numPlayers; i++){
            for(RouteCard c:gameState.getPlayerHands().get(i).getRouteCards()){
                String[] s = c.getName().split(" - ");
                City c1 = gameState.getGraph().cities.get(s[0]);
                City c2 = gameState.getGraph().cities.get(s[1]);
                if(gameState.getGraph().isConnected(c1, c2, new ArrayList<City>(), i))
                    scores[i] += c.getValue();
            }
            for(City c:gameState.getGraph().getCities().values()){
                for(String s:c.getRoutes().keySet()){
                    Route r = c.getRoutes().get(s);
                    if(r.getPlayerNum() == i){
                        if(r.getLength() == 1)
                            scores[i] += 1;
                        else if(r.getLength() == 2)
                            scores[i] += 2;
                        else if(r.getLength() == 3)
                            scores[i] += 4;
                        else if(r.getLength() == 4)
                            scores[i] += 7;
                        else if(r.getLength() == 5)
                            scores[i] += 10;
                        else if(r.getLength() == 6)
                            scores[i] += 15;
                        r.setPlayerNum(-1);
                        City c1 = c;
                        City c2 = r.getCity();
                        Route rReverse;
                        if(s.contains("1"))
                            rReverse = c2.getRoutes().get(c1.getName()+"1");
                        else if(s.contains("2"))
                            rReverse = c2.getRoutes().get(c1.getName()+"2");
                        else
                            rReverse = c2.getRoutes().get(c1.getName());
                        rReverse.setPlayerNum(-1);
                    }
                }
            }
        }
        int maxScoreIdx = 0;
        for(int i = 0; i < numPlayers; i++){
            if(scores[i] > maxScoreIdx)
                maxScoreIdx = i;
        }
        String s = "Player "+maxScoreIdx+" wins!\n" +
                "Scores:\n";
        for(int i = 0; i < numPlayers; i++){
            s.concat("Player "+i+":\t"+scores[i]+"\n");
        }
        return s;
    }

    @Override
    protected boolean makeMove(GameAction action) {
       if (action instanceof DrawTrainDeckFaceUpGameAction) {
           if (gameState.drawFaceUp(getPlayerIdx(action.getPlayer()), ((DrawTrainDeckFaceUpGameAction) action).getCard()) == null)
               return false;
       }
       else if (action instanceof DrawTrainDeckGameAction) {
           if (gameState.drawDeck(getPlayerIdx(action.getPlayer())) == null)
               return false;
       }
       else if (action instanceof DrawRouteDeckGameAction) {
           if (gameState.drawRouteCards(getPlayerIdx(action.getPlayer())) == null)
               return false;
       }
       else if (action instanceof ClaimRouteGameAction) {
           if (!gameState.claimRoute(getPlayerIdx(action.getPlayer()), ((ClaimRouteGameAction) action).getRoute()))
               return false;
       }
       else return false;
       return true;

    }

    private String getAssignedPlayerColor(int playerNumber){
        switch(playerNumber){
            case 0:
                return "Purple";
            case 1:
                return "White";
            case 2:
                return "Blue";
            case 3:
                return "Yellow";
            case 4:
                return "Orange";
            case 5:
                return "Black";
            case 6:
                return "Red";
            case 7:
                return "Green";
        }
        return null;
    }
}
