package ttr.up.edu.tickettoride;

import java.util.ArrayList;

import ttr.up.edu.game.infoMsg.GameState;

public class TTR_GameState extends GameState{
    private TrainDeck trainDeck;
    private Card[] publicCards;
    private RouteDeck routeDeck;
    private ArrayList<Hand> hands;
    private TrainStash trainStash;
    private Board board;
    private int currentPlayer;
    private int cardsDrawn;

    /**
     * Default GameState ctor
     */
    public TTR_GameState(){
        trainDeck = new TrainDeck();
        publicCards = new Card[5];
        for(int i=0; i<5; i++){
            publicCards[i] = trainDeck.draw();
        }
        routeDeck = new RouteDeck();
        hands = new ArrayList<>();
        trainStash = new TrainStash();
        board = new Board();
        currentPlayer = 0;
        cardsDrawn = 0;
    }

    /**
     * Deep-copy ctor
     * @param state GameState to copy
     * @throws CloneNotSupportedException if it cannot copy the ArrayList of hands
     */
    public TTR_GameState(TTR_GameState state) throws CloneNotSupportedException {
        trainDeck = new TrainDeck(state.trainDeck);
        routeDeck = new RouteDeck(state.routeDeck);
        hands = new ArrayList<>();
        for(Hand h: state.hands)
            hands.add(h.clone());
        trainStash = new TrainStash();
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
        if(currentPlayer != player)
            return false;

        if(publicCards[card].getName().equals("Rainbow Train")) {
            if (cardsDrawn == 1)
                return false;
            cardsDrawn += 2;
        }
        else
            cardsDrawn++;
        hands.get(player).addTrainCards(publicCards[card]);
        publicCards[card] = trainDeck.draw();
        if(cardsDrawn == 2) {
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
        cardsDrawn++;
        hands.get(player).addTrainCards(trainDeck.draw());
        if(cardsDrawn == 2){
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
        if (currentPlayer != player || cardsDrawn != 0)
            return false;
        
    }

    public void endTurn(){
        currentPlayer = (currentPlayer+1)%hands.size();
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Train Deck: \n");
        out.append(trainDeck.toString());
        out.append("Route Deck: \n");
        for (int i=0; i<hands.size(); i++) {
            out.append("Hand "+i+": ");
            out.append(hands.toString());
        }
        out.append("Board: \n");
        out.append(board.toString());
        out.append("Current player: "+ currentPlayer + "\n");
        return out.toString();
    }
}
