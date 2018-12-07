package ttr.up.edu.tickettoride;

/**
 * class RouteDeck
 * <p>
 * is a class to implement Deck for the Route Cards (default ctor creates the full deck of Route Cards)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 */

import java.util.ArrayList;
import java.util.Arrays;

public class RouteDeck {
    /**
     * Create a new BoardRoute Card Deck with all thirty destination cards.
     */
    protected ArrayList<RouteCard> cards;
    protected ArrayList<RouteCard> discard;

    public RouteDeck() {
        RouteCard[] routeCards = {
                new RouteCard("Winnipeg - Little Rock", 11),
                new RouteCard("Denver - Pittsburgh", 11),
                new RouteCard("Portland - Phoenix", 11),
                new RouteCard("Vancouver - Santa Fe", 13),
                new RouteCard("Calgary - Phoenix", 13),
                new RouteCard("Los Angeles - Miami", 20),
                new RouteCard("Los Angeles - New York", 21),
                new RouteCard("Boston - Miami", 12),
                new RouteCard("San Francisco - Atlanta", 17),
                new RouteCard("Portland - Nashville", 17),
                new RouteCard("Vancouver - Montreal", 20),
                new RouteCard("Seattle - New York", 22),
                new RouteCard("Dallas - New York", 11),
                new RouteCard("Los Angeles - Chicago", 16),
                new RouteCard("Toronto - Miami", 10),
                new RouteCard("Helena - Los Angeles", 8),
                new RouteCard("Sault St. Marie - Nashville", 8),
                new RouteCard("Duluth - Houston", 8),
                new RouteCard("Seattle - Los Angeles", 9),
                new RouteCard("Montreal - Atlanta", 9),
                new RouteCard("Sault St. Marie - Oklahoma City", 9),
                new RouteCard("Denver - El Paso", 4),
                new RouteCard("New York - Atlanta", 6),
                new RouteCard("Chicago - New Orleans", 7),
                new RouteCard("Kansas City - Houston", 5),
                new RouteCard("Calgary - Salt Lake City", 7)
        };
        cards = new ArrayList<>();
        discard = new ArrayList<>();
        cards.addAll(Arrays.asList(routeCards));
        shuffle();
    }

    public RouteDeck(RouteDeck deck) {
        cards = new ArrayList<>();
        discard = new ArrayList<>();
        for (RouteCard c : deck.cards)
            cards.add(c.clone());
        for (RouteCard c : deck.discard)
            cards.add(c.clone());
        shuffle();
    }

    /**
     * shuffles the deck randomly
     */
    public void shuffle() {
        for (int i = 0; i < cards.size() - 1; i++) {
            swap(i, (int) (Math.random() * (cards.size() - i) + i));
        }
    }

    /**
     * swaps the positions of two cards (used for shuffling)
     *
     * @param i index of the first card
     * @param j index of the card to switch with the first card
     */
    private void swap(int i, int j) {
        RouteCard c = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, c);
    }

    /**
     * draw cards from the deck (removes cards from the deck)
     *
     * @return the list of the cards that were drawn
     */
    public RouteCard draw() {
        if (cards.size() == 0) {
            if (discard.size() == 0)
                return null;//no cards left in deck
            cards.addAll(discard);
            discard.clear();
            shuffle();
        }
        return cards.remove(cards.size() - 1);
    }

    /**
     * add the given cards to the discard pile (when a player claims a route)
     *
     * @param card the cards which will be discarded
     */

    public void discard(RouteCard card) {
        discard.add(card);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Cards: ");
        for (Card c : cards)
            out.append(c.getName() + ", ");
        out.append("\nDiscards: ");
        for (Card c : discard)
            out.append(c.getName() + ", ");
        out.append("\n");
        return out.toString();
    }
}
