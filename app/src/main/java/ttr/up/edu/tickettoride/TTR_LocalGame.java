package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GameComputerPlayer;
import ttr.up.edu.game.GameHumanPlayer;
import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.game.actionMsg.GameAction;

public class TTR_LocalGame extends LocalGame {

    TTR_GameState gameState;

    public TTR_LocalGame() {
        gameState = new TTR_GameState();
    }



    /**
     * Pick new route cards
     * @param player player drawing route cards
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

       /*if (action instanceof DrawTrainFaceUpGameAction) return drawTrainFaceUp(action);
       else if (action instanceof DrawTrainDeckGameAction) return false;
       else if (action instanceof DrawRouteDeckGameAction) return false;
       else return false;*/
       return false;

    }

    /*private boolean drawTrainFaceUp(GameAction action){

        DrawTrainFaceUpGameAction drawAction = (DrawTrainFaceUpGameAction) action;

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
