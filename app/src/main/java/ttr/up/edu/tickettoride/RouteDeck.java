package ttr.up.edu.tickettoride;

import android.content.Context;
import android.graphics.BitmapFactory;

import java.util.Arrays;

public class RouteDeck extends Deck {

    /**
     * Create a new Route Card Deck with all thirty destination cards.
     */
    public RouteDeck() {
        Card[] routeCards = {
            new Card("Winnipeg - Little Rock"),
            new Card("Denver - Pittsburgh"),
            new Card("Portland - Phoenix"),
            new Card("Vancouver - Santa Fe"),
            new Card("Calgary - Phoenix"),
            new Card("Los Angeles - Miami"),
            new Card("Los Angeles - New York"),
            new Card("Boston - Miami"),
            new Card("San Francisco - Atlanta"),
            new Card("Portland - Nashville"),
            new Card("Vancouver - Montreal"),
            new Card("Seattle - New York"),
            new Card("Dallas - New York"),
            new Card("Los Angeles - Chicago"),
            new Card("Toronto - Miami"),
            new Card("Helena - Los Angeles"),
            new Card("Sault Ste. Marie - Nashville"),
            new Card("Duluth - Houston"),
            new Card("Seattle - Los Angeles"),
            new Card("Montreal - Atlanta"),
            new Card("Sault Ste. Marie - Oklahoma City"),
            new Card("Denver - El Paso"),
            new Card("New York - Atlanta"),
            new Card("Chicago - New Orleans"),
            new Card("Kansas City - Houston"),
            new Card("Calgary - Salt Lake City")
        };
        cards.addAll(Arrays.asList(routeCards));
        shuffle();
    }

    public RouteDeck(RouteDeck deck) throws CloneNotSupportedException {
        super(deck);
    }
}
