package ttr.up.edu.tickettoride;

import org.junit.Test;

import static org.junit.Assert.*;

public class TTR_GameStateTest {

    @Test
    public void drawFaceUp() {
        TTR_GameState state = new TTR_GameState(2);
        Card c = state.drawFaceUp(0, 2);

        assertNotEquals(c, null);
        assertNotEquals(c.getName(), "");
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