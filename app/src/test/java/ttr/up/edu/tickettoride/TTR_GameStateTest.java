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

    @Test
    public void drawDeck() {

    }

    @Test
    public void drawRouteCards() {
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