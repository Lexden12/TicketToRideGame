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
    Context context;
    /**
     * Create a new BoardRoute Card Deck with all thirty destination cards.
     */
    public RouteDeck(Context context) {
        this.context = context;
        Card[] routeCards = {
            new Card("Winnipeg - Little Rock", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest1)),
            new Card("Denver - Pittsburgh", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest2)),
            new Card("Portland - Phoenix", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest3)),
            new Card("Vancouver - Santa Fe", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest4)),
            new Card("Calgary - Phoenix", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest5)),
            new Card("Los Angeles - Miami", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest6)),
            new Card("Los Angeles - New York", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest7)),
            new Card("Boston - Miami", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest8)),
            new Card("San Francisco - Atlanta", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest9)),
            new Card("Portland - Nashville", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest10)),
            new Card("Vancouver - Montreal", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest11)),
            new Card("Seattle - New York", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest12)),
            new Card("Dallas - New York", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest13)),
            new Card("Los Angeles - Chicago", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest14)),
            new Card("Toronto - Miami", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest15)),
            new Card("Helena - Los Angeles", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest16)),
            new Card("Sault St. Marie - Nashville", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest17)),
            new Card("Duluth - Houston", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest18)),
            new Card("Seattle - Los Angeles", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest19)),
            new Card("Montreal - Atlanta", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest20)),
            new Card("Sault Ste. Marie - Oklahoma City", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest21)),
            new Card("Denver - El Paso", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest22)),
            new Card("New York - Atlanta", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest23)),
            new Card("Chicago - New Orleans", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest24)),
            new Card("Kansas City - Houston", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest25)),
            new Card("Calgary - Salt Lake City", BitmapFactory.decodeResource(context.getResources(), R.drawable.dest26))
        };
        cards.addAll(Arrays.asList(routeCards));
        shuffle();
    }

    public RouteDeck(RouteDeck deck) {
        super(deck);
        this.context = deck.context;
    }
}
