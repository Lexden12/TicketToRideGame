package ttr.up.edu.tickettoride;

import java.util.ArrayList;

/**
 * class PlayerHand
 *
 * is a class to represent a player's cards, containing both trainCards and routeCards
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class PlayerHand {
    private ArrayList<Card> trainCards;
    private ArrayList<Card> routeCards;
    //Add score and train pieces to store all player accessible data here.

    /**
     * Create a new PlayerHand with an arraylist to keep track of the trainCards in our hand
     * and the routecards in our hand
     */
    public PlayerHand(){
        trainCards = new ArrayList<>();
        routeCards = new ArrayList<>();
    }

    public PlayerHand clone(){
        PlayerHand playerHand = new PlayerHand();
        for(Card c:trainCards)
            playerHand.addTrainCard(c.clone());
        for(Card c:routeCards)
            playerHand.addRouteCard(c.clone());
        return playerHand;
    }

    public ArrayList<Card> getRouteCards() {
        return routeCards;
    }

    public ArrayList<Card> getTrainCards() {
        return trainCards;
    }

    public void setRouteCards(ArrayList<Card> routeCards) {
        this.routeCards = routeCards;
    }

    public void setTrainCards(ArrayList<Card> trainCards) {
        this.trainCards = trainCards;
    }

    /**
     * In the event that we draw a train card, this will add the cards to our hand
     * @param card the arraylist of cards to add to our hand
     */
    public void addTrainCard(Card card){
        trainCards.add(card);
    }

    /**
     * In the event that we draw a route card, this will add the cards to our hand
     * @param card the arraylist of cards to add to our hand
     */
    public void addRouteCard(Card card){
        routeCards.add(card);
    }


    /**
     * When we claim a route, this method will discard our train cards.
     * @param name the name of the card we are using (ex: "Red Train")
     * @param count the number of these cards required by the route (the number that will be discarded)
     * @return the cards which have been discarded (so that they can be added to the discard deck)
     */
    public ArrayList<Card> discard(String name, int count) {
        ArrayList<Card> discards = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            boolean hasCard = false;
            for (int j = 0; j < trainCards.size(); j++) {
                if (trainCards.get(j).getName().equals(name)) {
                    discards.add(trainCards.remove(j));
                    hasCard = true;
                    break;
                }
            }
            if(!hasCard) {
                trainCards.addAll(discards);
                sort();
                return null;
            }
        }
        return discards;
    }

    /**
     * no practical purpose, but it is so aesthetically pleasing when your cards are sorted by routeColor
     */
    public void sort() {
        for(int i = 0; i < trainCards.size(); i++){
            int index = minIndex(trainCards, i);
            if(index != i)
                swap(trainCards, i, index);
        }
    }

    /**
     * Used to find the index of the card with the least value name (used for sorting)
     * @param cards the cards to search for the least value
     * @param l the index at which we will start our search
     * @return the index of the least value card starting at l
     */
    private int minIndex(ArrayList<Card> cards, int l){
        String min = cards.get(l).getName();
        int index = l;
        for(int i = l; i < cards.size(); i++){
            if(min.compareTo(cards.get(i).getName()) < 0){
                min = cards.get(i).getName();
                index = i;
            }
        }
        return index;
    }

    /**
     * switches the positions of the card at index1 with the card at index2 (used for sorting)
     * @param cards the list of cards which contains the cards we are swapping
     * @param index1 index of the first card
     * @param index2 index of the card we are swapping with the first card
     */
    private void swap(ArrayList<Card> cards, int index1, int index2){
        Card c = cards.get(index1);
        cards.set(index1, cards.get(index2));
        cards.set(index2, c);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Train Cards: ");
        for (Card c:trainCards)
            out.append(c.getName()+", ");
        out.append("\n");
        out.append("Route Cards: ");
        for (Card c:routeCards){
            if(c!=null)
                out.append(c.getName()+", ");
        }
        out.append("\n");
        return out.toString();
    }

    public int getTrainCardsSize(){
        return trainCards.size();
    }
}
