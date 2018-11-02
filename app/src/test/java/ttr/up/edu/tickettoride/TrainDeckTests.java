package ttr.up.edu.tickettoride;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TrainDeckTests {
    @Test
    public void testTrainDeckConstructor(){
        TrainDeck deck = new TrainDeck();
        ArrayList<Card> trainCards = new ArrayList<>();
        Card draw = deck.draw();
        while(draw != null) {
            trainCards.add(draw);
            draw = deck.draw();
        }
        assertEquals(110, trainCards.size());
    }

    @Test
    public void testTrainDeckReshuffle(){
        TrainDeck deck = new TrainDeck();
        for(int i=0; i<200; i++) {
            Card c = deck.draw();
            assertNotEquals(null, c);
            deck.discard(c);
        }
    }
}
