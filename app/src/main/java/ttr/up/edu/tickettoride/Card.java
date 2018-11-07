package ttr.up.edu.tickettoride;

import android.graphics.Bitmap;

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
    private Bitmap bmp;

    /**
     * Construct a new Card from scratch
     * @param name the name of the card to be used when comparing cards
     */
    public Card(String name, Bitmap bmp){
        this.name = name;
        this.bmp = bmp;
    }

    public Card clone(){
        Card c = new Card(getName(), getBmp());
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

    public Bitmap getBmp() {
        return bmp;
    }
}
