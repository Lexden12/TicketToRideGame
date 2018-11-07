package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class DrawRouteDeckGameAction
 *
 * is a class to represent a player drawing from the route deck (unimplemented)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class DrawRouteDeckGameAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    int discard[];

    public DrawRouteDeckGameAction(GamePlayer player) {
        super(player);
        discard = new int[]{0, 0, 0};
    }

    public void setDiscard(int cardIndex){
        discard[cardIndex] = 1;
    }
}
