package ttr.up.edu.tickettoride;

import java.util.ArrayList;

/**
 * class PlayerHand
 * <p>
 * is a class to represent a player's cards, containing both trainCards and routeCards
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 */

public class PlayerHand {
    int[] cardsCounts;
    private ArrayList<Card> trainCards;
    private ArrayList<RouteCard> routeCards;
    private String color;
    private int trains;
    //Add score and train pieces to store all player accessible data here.

    /**
     * Create a new PlayerHand with an arraylist to keep track of the trainCards in our hand
     * and the routecards in our hand
     * Also initialize the number of trains to 45
     */
    public PlayerHand(String color) {
        trainCards = new ArrayList<>();
        routeCards = new ArrayList<>();
        cardsCounts = new int[9];
        this.color = color;
        trains = 45;
    }

    /**
     * Make a clone of this instance
     *
     * @return a PlayerHand clone
     */
    public PlayerHand clone() {
        PlayerHand playerHand = new PlayerHand(new String(this.color));
        for (Card c : trainCards)
            playerHand.addTrainCard(c.clone());
        for (RouteCard c : routeCards)
            playerHand.addRouteCard((RouteCard) c.clone());
        return playerHand;
    }


    /**
     * In the event that we draw a train card, this will add the cards to our hand
     *
     * @param card the card to add to our hand
     */
    public void addTrainCard(Card card) {
        if (card != null) {
            trainCards.add(card);
            if (card.getName().equals("Black Train"))
                cardsCounts[0]++;
            else if (card.getName().equals("Blue Train"))
                cardsCounts[1]++;
            else if (card.getName().equals("Green Train"))
                cardsCounts[2]++;
            else if (card.getName().equals("Orange Train"))
                cardsCounts[3]++;
            else if (card.getName().equals("Purple Train"))
                cardsCounts[4]++;
            else if (card.getName().equals("Rainbow Train"))
                cardsCounts[5]++;
            else if (card.getName().equals("Red Train"))
                cardsCounts[6]++;
            else if (card.getName().equals("White Train"))
                cardsCounts[7]++;
            else if (card.getName().equals("Yellow Train"))
                cardsCounts[8]++;
        }
    }

    /**
     * In the event that we draw a route card, this will add the cards to our hand
     *
     * @param card the arraylist of cards to add to our hand
     */
    public void addRouteCard(RouteCard card) {
        routeCards.add(card);
    }

    /**
     * When we claim a route, this method will discard our train cards.
     *
     * @param name  the name of the card we are using (ex: "Red Train")
     * @param count the number of these cards required by the route (the number that will be discarded)
     * @return the cards which have been discarded (so that they can be added to the discard deck)
     */
    public ArrayList<Card> discard(String name, int count) {
        ArrayList<Card> discards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            boolean hasCard = false;

            for (int j = 0; j < trainCards.size(); j++) {
                if (!name.equals("Grey Train") && trainCards.get(j).getName().equals(name)) {
                    discards.add(trainCards.remove(j));
                    hasCard = true;
                    break;
                } else if (name.equals("Grey Train")) {
                    discards.add(trainCards.remove(j));
                    hasCard = true;
                    break;
                }
            }
            if (!hasCard) {
                trainCards.addAll(discards);
                sort();
                return null;
            }
            if (name.equals("Black Train"))
                cardsCounts[0]--;
            else if (name.equals("Blue Train"))
                cardsCounts[1]--;
            else if (name.equals("Green Train"))
                cardsCounts[2]--;
            else if (name.equals("Orange Train"))
                cardsCounts[3]--;
            else if (name.equals("Purple Train"))
                cardsCounts[4]--;
            else if (name.equals("Rainbow Train"))
                cardsCounts[5]--;
            else if (name.equals("Red Train"))
                cardsCounts[6]--;
            else if (name.equals("White Train"))
                cardsCounts[7]--;
            else if (name.equals("Yellow Train"))
                cardsCounts[8]--;
        }
        trains -= discards.size();
        return discards;
    }

    /**
     * no practical purpose, but it is so aesthetically pleasing when your cards are sorted by card color
     */
    public void sort() {
        for (int i = 0; i < trainCards.size(); i++) {
            int index = minIndex(trainCards, i);
            if (index != i)
                swap(trainCards, i, index);
        }
    }

    /**
     * Used to find the index of the card with the least value name (used for sorting)
     *
     * @param cards the cards to search for the least value
     * @param l     the index at which we will start our search
     * @return the index of the least value card starting at l
     */
    private int minIndex(ArrayList<Card> cards, int l) {
        String min = cards.get(l).getName();
        int index = l;
        for (int i = l; i < cards.size(); i++) {
            if (min.compareTo(cards.get(i).getName()) < 0) {
                min = cards.get(i).getName();
                index = i;
            }
        }
        return index;
    }

    /**
     * switches the positions of the card at index1 with the card at index2 (used for sorting)
     *
     * @param cards  the list of cards which contains the cards we are swapping
     * @param index1 index of the first card
     * @param index2 index of the card we are swapping with the first card
     */
    private void swap(ArrayList<Card> cards, int index1, int index2) {
        Card c = cards.get(index1);
        cards.set(index1, cards.get(index2));
        cards.set(index2, c);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Train Cards: ");
        for (Card c : trainCards)
            out.append(c.getName() + ", ");
        out.append("\n");
        out.append("Route Cards: ");
        for (Card c : routeCards) {
            if (c != null)
                out.append(c.getName() + ", ");
        }
        out.append("\n");
        return out.toString();
    }

    //getters and setters
    public int getTrainCardsSize() {
        return trainCards.size();
    }

    public String getColor() {
        return color;
    }

    public int getCardCount(int c) {
        return cardsCounts[c];
    }

    public ArrayList<RouteCard> getRouteCards() {
        return routeCards;
    }

    public void setRouteCards(ArrayList<RouteCard> routeCards) {
        this.routeCards = routeCards;
    }

    public ArrayList<Card> getTrainCards() {
        return trainCards;
    }

    public void setTrainCards(ArrayList<Card> trainCards) {
        this.trainCards = trainCards;
    }

    public int getTrains() {
        return trains;
    }

    protected void setTrains(int trains) {
        this.trains = trains;
    }
}
