package ttr.up.edu.tickettoride;

/**
 * class Deck
 *
 * is a class to store all the cards in a particular deck (either train or route)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

import java.util.ArrayList;

public abstract class Deck {
    protected ArrayList<Card> cards;
    protected ArrayList<Card> discard;

    public Deck(){
        cards = new ArrayList<>();
        discard = new ArrayList<>();
    }

    public Deck(Deck deck) {
        for(Card c:deck.cards)
            cards.add(c.clone());
        for(Card c:deck.discard)
            cards.add(c.clone());
    }

    /**
     * shuffles the deck randomly
     */
    public void shuffle(){
        for(int i=0; i<cards.size()-1; i++){
            swap(i, (int)(Math.random()*(cards.size()-i)+i), cards);
        }
    }

    /**
     * swaps the positions of two cards (used for shuffling)
     * @param i index of the first card
     * @param j index of the card to switch with the first card
     * @param list list containing the cards we want to swap
     */
    public void swap(int i, int j, ArrayList<Card> list){
        Card c = list.get(i);
        list.set(i, list.get(j));
        list.set(j, c);
    }

    /**
     * draw cards from the deck (removes cards from the deck)
     * @return the list of the cards that were drawn
     */
    public Card draw(){
        return cards.remove(cards.size()-1);
    }

    /**
     * add the given cards to the discard pile (when a player claims a route)
     * @param card the cards which will be discarded
     */

    public void discard(Card card){
        discard.add(card);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append("Cards: ");
        for (Card c:cards)
            out.append(c.getName()+", ");
        out.append("\nDiscards: ");
        for(Card c:discard)
            out.append(c.getName()+", ");
        out.append("\n");
        return out.toString();
    }
}
