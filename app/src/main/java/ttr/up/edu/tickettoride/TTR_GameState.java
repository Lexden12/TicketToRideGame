package ttr.up.edu.tickettoride;

import android.content.Context;

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
    protected Card[] faceUpTrainCards;
    private RouteDeck routeDeck;
    private TrainPieceStash trainPieceStash;
    private CityGraph graph;
    private int turnsLeft;

    //player specific information
    private ArrayList<PlayerHand> playerHands;

    //turn specific information
    private int currentPlayer;

    private int numTrainCardsDrawn;

    private int numRouteCardsDrawn;

    private Card[] routeCards;

    /**
     * Default GameState ctor
     */
    public TTR_GameState(int numPlayers){
        trainDeck = new TrainDeck();
        faceUpTrainCards = new Card[5];
        for(int i=0; i<5; i++){
            faceUpTrainCards[i] = trainDeck.draw();
        }
        routeDeck = new RouteDeck();
        playerHands = new ArrayList<>();
        for(int i=0;i<numPlayers;i++)
            playerHands.add(new PlayerHand());
        trainPieceStash = new TrainPieceStash();
        currentPlayer = 0;
        numTrainCardsDrawn = 0;
        numRouteCardsDrawn = 0;
        routeCards = new Card[3];
        graph = new CityGraph();
        turnsLeft = -1;
    }

    /**
     * Deep-copy ctor
     * @param state GameState to copy
     */
    public TTR_GameState(TTR_GameState state){
        trainDeck = new TrainDeck(state.trainDeck);
        faceUpTrainCards = new Card[5];
        for(int i=0;i<5;i++)
            faceUpTrainCards[i] = state.faceUpTrainCards[i];
        routeDeck = new RouteDeck(state.routeDeck);
        playerHands = new ArrayList<>();
        for(PlayerHand h: state.playerHands)
            playerHands.add(h.clone());
        trainPieceStash = new TrainPieceStash();
        currentPlayer = state.currentPlayer;
        graph = state.graph;
        turnsLeft = -1;
    }

    /**
     * draw four train cards and three route cards for each player (as required to start the game).
     */
    private void init(){
        for(int i=0;i<playerHands.size();i++){
            for(int j=0;j<4;j++) {
                Card c = trainDeck.draw();
                playerHands.get(i).addTrainCard(c);
            }
            drawRouteCards(i);
            endTurn();
        }
        //notify
    }

    /**
     * Methods to perform actions
     * Draws a card from the public, face up cards
     * @param player id of the player who is performing the action
     * @param card card the player is drawing
     * @return true if valid and completed turn. False otherwise.
     */
    public Card drawFaceUp(int player, int card){
        //modified here
        if(currentPlayer != player || numRouteCardsDrawn > 0)
            return null;

        if(faceUpTrainCards[card].getName().equals("Rainbow Train")) {
            if (numTrainCardsDrawn == 1)
                return null;
            numTrainCardsDrawn += 2;
        }
        else
            numTrainCardsDrawn++;
        playerHands.get(player).addTrainCard(faceUpTrainCards[card]);
        Card c = faceUpTrainCards[card];
        faceUpTrainCards[card] = trainDeck.draw();
        if(numTrainCardsDrawn == 2) {
            endTurn();
        }
        int numRainbow = 0;
        for(Card card1:faceUpTrainCards){
            if(card1 != null && card1.getName().equals("Rainbow Train"))
                numRainbow++;
        }
        if(numRainbow >= 3){
            for (int i=0;i<faceUpTrainCards.length;i++){
                trainDeck.discard(faceUpTrainCards[i]);
                faceUpTrainCards[i] = trainDeck.draw();
            }
            //notify
        }
        return c;
    }

    /**
     * End the current turn by setting route cards (if applicable) and setting it to the next player's turn
     */
    public void endTurn(){
        if(numRouteCardsDrawn>0)
            for (Card c:routeCards)
                if(c != null)
                    playerHands.get(currentPlayer).addRouteCard(c);
        currentPlayer = (currentPlayer+1)% playerHands.size();
        routeCards = new Card[3];
        numRouteCardsDrawn = 0;
        numTrainCardsDrawn = 0;
        if(turnsLeft == -1 && playerHands.get(currentPlayer).getTrains() < 3) turnsLeft = playerHands.size();
        if(turnsLeft != -1) turnsLeft--;
    }

    /**
     * Draw from the deck
     * @param player player that is drawing from the deck
     * @return successful completion of the draw
     */
    public Card drawDeck(int player){
        if(currentPlayer != player)
            return null;
        numTrainCardsDrawn++;
        Card c = trainDeck.draw();
        playerHands.get(player).addTrainCard(c);
        if(numTrainCardsDrawn == 2){
            endTurn();
        }
        return c;
    }

    /**
     * Pick new route cards
     * @param player player drawing route cards
     * @return successful completion of draw
     */
    public Card[] drawRouteCards(int player){
        if (currentPlayer != player || numTrainCardsDrawn != 0 || numRouteCardsDrawn != 0)
            return null;
        for (int i=0; i<3; i++) {
            Card c;
            if((c = routeDeck.draw())!=null)
                routeCards[i] = c;
        }
        numRouteCardsDrawn = 3;
        if(routeCards[0] != null)
            endTurn();
        else
            numRouteCardsDrawn = 0;
        return routeCards;
    }

    public Card discardRouteCard(int player, int idx){
        if (currentPlayer != player || numTrainCardsDrawn != 0 || numRouteCardsDrawn<2)
            return null;
        routeDeck.discard(routeCards[idx]);
        numRouteCardsDrawn--;
        Card c = new Card(routeCards[idx]);
        routeCards[idx] = null;
        return c;
    }

    /**
     * Claim the given route on the board.
     * @param player the player who wants to claim a route
     * @param route the route the player wants to claim
     * @return true for successful completion, false otherwise.
     */
    public boolean claimRoute(int player, String route) {
        if (currentPlayer != player || numTrainCardsDrawn != 0 || numRouteCardsDrawn != 0)
            return false;
        String[] cities = route.split("<->");
        City c1 = graph.cities.get(cities[0]);
        City c2 = graph.cities.get(cities[1]);
        if (cities[1].contains("1") || cities[1].contains("2"))
            c2 = graph.cities.get(cities[1].substring(0, cities[1].length()-1));
        Route r1 = c1.getRoutes().get(cities[1]);
        int totalMatch = 0;
        if(!r1.color.equals("Grey")) {
            for (Card c : playerHands.get(player).getTrainCards())
                if (c.getName().contains(r1.color)) totalMatch++;
        }
        else{
            for (Card c : playerHands.get(player).getTrainCards())
                totalMatch++;
        }
        if (totalMatch < r1.length) {
            int rainbow = 0;
            int needed = r1.length - totalMatch;
            for (Card c : playerHands.get(player).getTrainCards()) {
                if (c.getName().equals("Rainbow Train") && needed > 0) {
                    rainbow++;
                    needed--;
                }
            }
            if (needed > 0)
                return false;
            for(Card c:playerHands.get(player).discard("Rainbow Train", rainbow))
                trainDeck.discard(c);
            for(Card c:playerHands.get(player).discard(r1.color + " Train", totalMatch))
                trainDeck.discard(c);
        }
        else{
            if(!r1.color.equals("Grey"))
                for(Card c:playerHands.get(player).discard(r1.color + " Train", r1.length))
                    trainDeck.discard(c);
            else
                for(Card c:playerHands.get(player).discard(r1.color + " Train", r1.length))
                    trainDeck.discard(c);
        }
        r1.setPlayerNum(player);
        if (cities[1].contains("1"))
            c2.getRoutes().get((c1.getName())+"1").setPlayerNum(player);
        else if(cities[1].contains("2"))
            c2.getRoutes().get((c1.getName())+"2").setPlayerNum(player);
        else
            c2.getRoutes().get(c1.getName()).setPlayerNum(player);

        return true;
    }

    //Getters/Setters

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



    public ArrayList<PlayerHand> getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(ArrayList<PlayerHand> playerHands) {
        this.playerHands = playerHands;
        init();
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
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

    public int getTurnsLeft() {
        return turnsLeft;
    }

    public CityGraph getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TrainDeck:\n");
        sb.append(trainDeck.toString());
        sb.append("FaceUp Cards:\n");
        for(Card c:faceUpTrainCards)
            sb.append(c.getName()+", ");
        sb.append("\nRoute Deck:\n");
        sb.append(routeDeck.toString());
        sb.append("Player Hand:\n");
        for(PlayerHand hand:playerHands)
            sb.append(hand.toString());
        sb.append("Current Player: "+currentPlayer);
        sb.append("\nNumber of Train Cards Drawn this turn: "+numTrainCardsDrawn);
        sb.append("\nNumber of Route Cards drawn this turn: "+numRouteCardsDrawn);
        sb.append("\n");
        return sb.toString();
    }
}
