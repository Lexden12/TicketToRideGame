package ttr.up.edu.tickettoride;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Card {
    private String name;

    /**
     * Construct a new Card from scratch
     * @param name the name of the card to be used when comparing cards
     */
    public Card(String name){
        this.name = name;
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
