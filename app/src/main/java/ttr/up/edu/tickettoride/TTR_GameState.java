package ttr.up.edu.tickettoride;

import java.util.ArrayList;

import ttr.up.edu.game.infoMsg.GameState;

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
        trainDeck = new TrainDeck(state.trainDeck);
        routeDeck = new RouteDeck(state.routeDeck);
        playerHands = new ArrayList<>();
        for(PlayerHand h: state.playerHands)
            playerHands.add(h.clone());
        trainPieceStash = new TrainPieceStash();
        board = new Board(state.board);

        currentPlayer = state.currentPlayer;
    }

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
