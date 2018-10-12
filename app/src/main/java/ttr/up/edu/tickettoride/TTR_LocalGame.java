package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.game.actionMsg.GameAction;

public class TTR_LocalGame extends LocalGame {

    TTR_GameState gameState;

    public TTR_LocalGame() {
        gameState = new TTR_GameState();
    }

    /**
     * Methods to perform actions
     * Draws a card from the public, face up cards
     * @param player id of the player who is performing the action
     * @param card card the player is drawing
     * @return true if valid and completed turn. False otherwise.
     */
    public boolean drawFaceUp(int player, int card){
        //modified here
        if(gameState.getCurrentPlayer() != player || gameState.numRouteCardsDrawn > 2)
            return false;

        if(faceupTrainCards[card].getName().equals("Rainbow Train")) {
            if (numTrainCardsDrawn == 1)
                return false;
            numTrainCardsDrawn += 2;
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

    /**
     * Draw from the deck
     * @param player player that is drawing from the deck
     * @return successful completion of the draw
     */
    public boolean drawDeck(int player){
        if(currentPlayer != player)
            return false;
        numTrainCardsDrawn++;
        playerHands.get(player).addTrainCards(trainDeck.draw());
        if(numTrainCardsDrawn == 2){
            endTurn();
        }
        return true;
    }

    /**
     * Pick new route cards
     * @param player player drawing route cards
     * @return successful completion of draw
     */
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

    public void endTurn(){
        if(numRouteCardsDrawn>0)

            currentPlayer = (currentPlayer+1)% playerHands.size();
        routeCards = new Card[3];
        numTrainCardsDrawn = 0;
    }

    @Override
    public String toString() {
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
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {

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

       if (action instanceof DrawTrainFaceUpGameAction){

           if(gameState.getCurrentPlayer() != action.getPlayer() || gameState.numRouteCardsDrawn > 2)
               return false;

           if(faceupTrainCards[card].getName().equals("Rainbow Train")) {
               if (numTrainCardsDrawn == 1)
                   return false;
               numTrainCardsDrawn += 2;
           }
           else
               numTrainCardsDrawn++;
           playerHands.get(player).addTrainCards(faceupTrainCards[card]);
           faceupTrainCards[card] = trainDeck.draw();
           if(numTrainCardsDrawn == 2) {
               endTurn();
           }
           return true;

       } else if (action instanceof DrawTrainDeckGameAction){

       } else if (action instanceof DrawRouteDeckGameAction){

       }

       return false;
    }
}
