package ttr.up.edu.tickettoride;

/**
 * class Card
 *
 * is a class to represent a card (either train or route)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class Card {
    private String name;

    /**
     * Construct a new Card from scratch
     * @param name the name of the card to be used when comparing cards
     */
    public Card(String name){
        this.name = name;
    }

    public Card clone(){
        Card c = new Card(getName());
        return c;
    }

    /**
     * Construct a new card by using an existing card
     * @param c the card whose instance variables we will copy from
     */
    public Card(Card c){
        this.name = c.name;
    }

    public String getName() {
        return name;
    }
}
