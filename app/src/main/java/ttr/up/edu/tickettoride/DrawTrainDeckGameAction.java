package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class DrawRouteDeckGameAction
 *
 * is a class to represent a player drawing from the train deck (unimplemented)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class DrawTrainDeckGameAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public DrawTrainDeckGameAction(GamePlayer player) {
        super(player);
    }
}
