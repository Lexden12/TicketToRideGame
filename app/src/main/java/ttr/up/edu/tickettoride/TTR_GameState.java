package ttr.up.edu.tickettoride;

import java.util.ArrayList;

import ttr.up.edu.game.infoMsg.GameState;

public class TTR_GameState extends GameState{


    //cards and trains available for use
    private TrainDeck trainDeck;
    private Card[] faceupTrainCards;
    private RouteDeck routeDeck;
    private TrainPieceStash trainPieceStash;
    private Board board;

    //player specific information
    private ArrayList<PlayerHand> playerHands;

    //turn specific information
    private int currentPlayer;

    private boolean drawTrainCardsFaceup;
    private int numTrainCardsDrawn;

    private Card[] routeCards;
    private int numRouteCardsDrawn;

    /**
     * Default GameState ctor
     */
    public TTR_GameState(){
        trainDeck = new TrainDeck();
        faceupTrainCards = new Card[5];
        for(int i=0; i<5; i++){
            faceupTrainCards[i] = trainDeck.draw();
        }
        routeDeck = new RouteDeck();
        playerHands = new ArrayList<PlayerHand>();
        trainPieceStash = new TrainPieceStash();
        board = new Board();
        currentPlayer = 0;
        numTrainCardsDrawn = 0;
        numRouteCardsDrawn = 0;
        routeCards = new Card[3];
        drawTrainCardsFaceup = false;
    }

    /**
     * Deep-copy ctor
     * @param state GameState to copy
     * @throws CloneNotSupportedException if it cannot copy the ArrayList of playerHands
     */
    public TTR_GameState(TTR_GameState state) throws CloneNotSupportedException {
        trainDeck = new TrainDeck(state.trainDeck);
        routeDeck = new RouteDeck(state.routeDeck);
        playerHands = new ArrayList<>();
        for(PlayerHand h: state.playerHands)
            playerHands.add(h.clone());
        trainPieceStash = new TrainPieceStash();
        board = new Board(state.board);

        currentPlayer = state.currentPlayer;
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
        if(currentPlayer != player || numRouteCardsDrawn > 2)
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
}
