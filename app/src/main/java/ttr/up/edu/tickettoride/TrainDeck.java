package ttr.up.edu.tickettoride;

import android.content.Context;
import android.graphics.BitmapFactory;

/**
 * class RouteDeck
 *
 * is a class to implement Deck for the Train Cards (default ctor creates the full deck of Train Cards)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TrainDeck extends Deck {
    Context context;
    /**
     * create a new Train Card Deck with the proper amounts of each type of card
     */
    public TrainDeck(Context context){
        Card[] trainCards = {new Card("Black Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.black_card)),
                new Card("Blue Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.blue_card)),
                new Card("Green Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.green_card)),
                new Card("Orange Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.orange_card)),
                new Card("Purple Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.purple_card)),
                new Card("Red Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.red_card)),
                new Card("White Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.white_card)),
                new Card("Yellow Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.yellow_card)),
                new Card("Rainbow Train", BitmapFactory.decodeResource(context.getResources(), R.drawable.rainbow_card))};
        for(int i = 0; i < 8; i++)
            for (int j = 0; j < 12; j++)
                cards.add(new Card(trainCards[i]));//add the regular cards
        for (int i = 0; i < 14; i++)
            cards.add(new Card(trainCards[8]));//add the rainbow cards
    }

    public TrainDeck(TrainDeck deck) {
        super(deck);
        this.context = deck.context;
    }
}
