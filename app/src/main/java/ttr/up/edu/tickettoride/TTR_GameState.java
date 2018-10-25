package ttr.up.edu.tickettoride;

import java.util.ArrayList;

import ttr.up.edu.game.infoMsg.GameState;

/**
 * class TTR_GameState
 *
 * is a class to extend GameState to store the current state of the Ticket To Ride Game.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TTR_GameState extends GameState{


    //cards and trains available for use
    private TrainDeck trainDeck;
    private Card[] faceUpTrainCards;
    private RouteDeck routeDeck;
    private TrainPieceStash trainPieceStash;
    private Board board;

    //player specific information
    private ArrayList<PlayerHand> playerHands;

    //turn specific information
    private int currentPlayer;

    private boolean drawTrainCardsFaceUp;
    private int numTrainCardsDrawn;

    private Card[] routeCards;
    private int numRouteCardsDrawn;

    /**
     * Default GameState ctor
     */
    public TTR_GameState(){
        trainDeck = new TrainDeck();
        faceUpTrainCards = new Card[5];
        for(int i=0; i<5; i++){
            faceUpTrainCards[i] = trainDeck.draw();
        }
        routeDeck = new RouteDeck();
        playerHands = new ArrayList<PlayerHand>();
        for (int i=0; i<4; i++) playerHands.add(new PlayerHand());
        trainPieceStash = new TrainPieceStash();
        board = new Board();
        currentPlayer = 0;
        numTrainCardsDrawn = 0;
        numRouteCardsDrawn = 0;
        routeCards = new Card[3];
        drawTrainCardsFaceUp = false;
    }

    /**
     * Deep-copy ctor
     * @param state GameState to copy
     * @throws CloneNotSupportedException if it cannot copy the ArrayList of playerHands
     */
    public TTR_GameState(TTR_GameState state) throws CloneNotSupportedException {
        trainDeck = new TrainDeck(state.getTrainDeck());
        routeDeck = new RouteDeck(state.getRouteDeck());
        playerHands = new ArrayList<>();
        for(PlayerHand h: state.getPlayerHands())
            playerHands.add(h.clone());
        trainPieceStash = new TrainPieceStash();
        board = new Board(state.getBoard());

        currentPlayer = state.getCurrentPlayer();
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
        if(currentPlayer != player || numRouteCardsDrawn > 0)
            return false;

        if(faceUpTrainCards[card].getName().equals("Rainbow Train")) {
            if (numTrainCardsDrawn == 1)
                return false;
            numTrainCardsDrawn += 2;
        }
        else
            numTrainCardsDrawn++;
        playerHands.get(player).addTrainCards(faceUpTrainCards[card]);
        faceUpTrainCards[card] = trainDeck.draw();
        if(numTrainCardsDrawn == 2) {
            endTurn(player);
        }
        return true;
    }

    public boolean endTurn(int player){
        if (currentPlayer != player) return false;

        if(numRouteCardsDrawn>0)
            for (Card c:routeCards)
                playerHands.get(currentPlayer).addRouteCards(c);
        currentPlayer = (currentPlayer+1)% playerHands.size();
        routeCards = new Card[3];
        numRouteCardsDrawn = 0;
        numTrainCardsDrawn = 0;
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
            endTurn(player);
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

    /*getters and setters*/
    public TrainDeck getTrainDeck() {
        return trainDeck;
    }

    public void setTrainDeck(TrainDeck trainDeck) {
        this.trainDeck = trainDeck;
    }

    public Card[] getFaceUpTrainCards() {
        return faceUpTrainCards;
    }

    public void setFaceUpTrainCards(Card[] faceUpTrainCards) {
        this.faceUpTrainCards = faceUpTrainCards;
    }

    public RouteDeck getRouteDeck() {
        return routeDeck;
    }

    public void setRouteDeck(RouteDeck routeDeck) {
        this.routeDeck = routeDeck;
    }

    public TrainPieceStash getTrainPieceStash() {
        return trainPieceStash;
    }

    public void setTrainPieceStash(TrainPieceStash trainPieceStash) {
        this.trainPieceStash = trainPieceStash;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ArrayList<PlayerHand> getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(ArrayList<PlayerHand> playerHands) {
        this.playerHands = playerHands;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isDrawTrainCardsFaceup() {
        return drawTrainCardsFaceUp;
    }

    public void setDrawTrainCardsFaceUp(boolean drawTrainCardsFaceUp) {
        this.drawTrainCardsFaceUp = drawTrainCardsFaceUp;
    }

    public int getNumTrainCardsDrawn() {
        return numTrainCardsDrawn;
    }

    public void setNumTrainCardsDrawn(int numTrainCardsDrawn) {
        this.numTrainCardsDrawn = numTrainCardsDrawn;
    }

    public Card[] getRouteCards() {
        return routeCards;
    }

    public void setRouteCards(Card[] routeCards) {
        this.routeCards = routeCards;
    }

    public int getNumRouteCardsDrawn() {
        return numRouteCardsDrawn;
    }

    public void setNumRouteCardsDrawn(int numRouteCardsDrawn) {
        this.numRouteCardsDrawn = numRouteCardsDrawn;
    }
}
