package ttr.up.edu.tickettoride;

/**
 * class RouteDeck
 *
 * is a class to implement Deck for the Route Cards (default ctor creates the full deck of Route Cards)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.Arrays;

public class RouteDeck extends Deck {
    /**
     * Create a new BoardRoute Card Deck with all thirty destination cards.
     */
    public RouteDeck() {
        Card[] routeCards = {
            new RouteCard("Winnipeg - Little Rock",11),
            new RouteCard("Denver - Pittsburgh",11),
            new RouteCard("Portland - Phoenix",11),
            new RouteCard("Vancouver - Santa Fe",13),
            new RouteCard("Calgary - Phoenix",13),
            new RouteCard("Los Angeles - Miami",20),
            new RouteCard("Los Angeles - New York",21),
            new RouteCard("Boston - Miami",12),
            new RouteCard("San Francisco - Atlanta",17),
            new RouteCard("Portland - Nashville",17),
            new RouteCard("Vancouver - Montreal",20),
            new RouteCard("Seattle - New York",22),
            new RouteCard("Dallas - New York",11),
            new RouteCard("Los Angeles - Chicago",16),
            new RouteCard("Toronto - Miami",10),
            new RouteCard("Helena - Los Angeles",8),
            new RouteCard("Sault St. Marie - Nashville",8),
            new RouteCard("Duluth - Houston",8),
            new RouteCard("Seattle - Los Angeles",9),
            new RouteCard("Montreal - Atlanta",9),
            new RouteCard("Sault St. Marie - Oklahoma City",9),
            new RouteCard("Denver - El Paso",4),
            new RouteCard("New York - Atlanta",6),
            new RouteCard("Chicago - New Orleans",7),
            new RouteCard("Kansas City - Houston",5),
            new RouteCard("Calgary - Salt Lake City",7)
        };
        cards.addAll(Arrays.asList(routeCards));
        shuffle();
    }

    @Override
    public RouteCard draw() {
        if(cards.size()==0) {
            if(discard.size()==0)
                return null;//no cards left in deck
            cards.addAll(discard);
            discard.clear();
            shuffle();
        }
        return (RouteCard) cards.remove(cards.size()-1);
    }

    public RouteDeck(RouteDeck deck) {
        super(deck);
    }
}
