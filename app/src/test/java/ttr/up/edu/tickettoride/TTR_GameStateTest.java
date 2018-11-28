package ttr.up.edu.tickettoride;

import org.junit.Test;

import static org.junit.Assert.*;

public class TTR_GameStateTest {
    /**
     * Tests whether we can draw a FaceUp card properly.
     * @author Alex Schendel
     */
    @Test
    public void drawFaceUp() {
        TTR_GameState state = new TTR_GameState(2);
        Card c = state.drawFaceUp(state.getCurrentPlayer(), 0);
        assertNotEquals(c, null);
        assertNotEquals(c.getName(), "");
        c = state.drawFaceUp(state.getCurrentPlayer(), 5);
        assertEquals(c, null);
    }

    /**
     * @author Ben LaFave
     */
    @Test
    public void drawDeck() {

        TTR_GameState state = new TTR_GameState(2);
        //current player is default of 0 when constructing gamestate
        Card c = state.drawDeck(0);
        assertNotEquals(c, null); //tests that card is not null
        assertNotEquals(c.getName(), null);
        //tests the card's values are not null / card has a name

        TTR_GameState state2 = new TTR_GameState(2);
        Card c2 = state.drawDeck(1);
        assertEquals(null, c2);     //since it is not player one's turn, the draw deck returns null.
    }

    @Test
    public void drawRouteCards() {
        //TTR_GameState state = new TTR_GameState(2);

    }

    @Test
    public void discardRouteCard() {
    }

    @Test
    public void setTrainDeck() {
    }

    @Test
    public void setFaceUpTrainCards() {
    }
}