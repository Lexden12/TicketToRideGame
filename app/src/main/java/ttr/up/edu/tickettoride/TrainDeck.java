package ttr.up.edu.tickettoride;

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

    /**
     * create a new Train Card Deck with the proper amounts of each type of card
     */
    public TrainDeck(){
        Card[] trainCards = {new Card("Black Train"),
                new Card("Blue Train"),
                new Card("Green Train"),
                new Card("Orange Train"),
                new Card("Purple Train"),
                new Card("Red Train"),
                new Card("White Train"),
                new Card("Yellow Train"),
                new Card("Rainbow Train")};
        for(int i = 0; i < 8; i++)
            for (int j = 0; j < 12; j++)
                cards.add(new Card(trainCards[i]));//add the regular cards
        for (int i = 0; i < 14; i++)
            cards.add(new Card(trainCards[8]));//add the rainbow cards
    }

    public TrainDeck(TrainDeck deck) {
        super(deck);
    }
}
