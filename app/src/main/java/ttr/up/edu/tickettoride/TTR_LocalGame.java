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

    public TTR_LocalGame(Context context) {
        gameState = new TTR_GameState(context, numPlayers);
    }

    @Override
    public void start(GamePlayer[] players) {
        numPlayers = players.length;
        ArrayList<PlayerHand> hands = new ArrayList<>();
        for(int i=0;i<numPlayers;i++){
            hands.add(new PlayerHand());
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
        return "Game over!";
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
}
