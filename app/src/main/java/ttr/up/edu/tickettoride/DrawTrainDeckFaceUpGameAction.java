package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class DrawTrainDeckFaceUpGameAction
 *
 * is a class to represent a player drawing from the face up train cards (unimplemented)
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class DrawTrainDeckFaceUpGameAction extends GameAction {

    private int card;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public DrawTrainDeckFaceUpGameAction(GamePlayer player, int card) {
        super(player);
        this.card = card;
    }

    public int getCard() {
        return card;
    }
}
