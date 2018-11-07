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

    /**
     * Pick new route cards
     * @param //player player drawing route cards
     * @return successful completion of draw
     */
    /*
    public boolean drawRouteCards(int player){
        if (currentPlayer != player || numTrainCardsDrawn != 0 || numRouteCardsDrawn>0)
            return false;
        for (int i=0; i<3; i++)
            routeCards[i] = routeDeck.draw();
        return true;
    }

    public boolean discardRouteCard(int player, int idx){
        if (currentPlayer != player || numTrainCardsDrawn != 0 || numRouteCardsDrawn<2)
            return false;
        routeDeck.discard(routeCards[idx]);
        routeCards[idx] = null;
        return true;
    }
    */


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
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {

       if (action instanceof DrawTrainDeckFaceUpGameAction) gameState.drawFaceUp(getPlayerIdx(action.getPlayer()), ((DrawTrainDeckFaceUpGameAction) action).getCard());
       else if (action instanceof DrawTrainDeckGameAction) gameState.drawDeck(getPlayerIdx(action.getPlayer()));
       else if (action instanceof DrawRouteDeckGameAction) gameState.drawRouteCards(getPlayerIdx(action.getPlayer()));
       else return false;
       return true;

    }

    /*private boolean drawTrainFaceUp(GameAction action){

        DrawTrainDeckFaceUpGameAction drawAction = (DrawTrainDeckFaceUpGameAction) action;

        //check if current player can move
        if (!canMove(getPlayerIdx(action.getPlayer()))) return false;


        if(faceupTrainCards[drawAction.getCard()].getName().equals("Rainbow Train")) {
            if (numTrainCardsDrawn == 1)
                return false;
            numTrainCardsDrawn += 1;
        }
        else
            numTrainCardsDrawn++;
        playerHands.get(player).addTrainCards(faceupTrainCards[card]);
        faceupTrainCards[card] = trainDeck.draw();
        if(numTrainCardsDrawn == 2) {
            endTurn();
        }
        return true;
    }


    private void nextTurn(){
        if (gameState.getCurrentPlayer() >= gameState.getPlayerHands().size()){
            gameState.setCurrentPlayer(0);
        } else {
            gameState.setCurrentPlayer(gameState.getCurrentPlayer()+1);
        }
    }*/
}
