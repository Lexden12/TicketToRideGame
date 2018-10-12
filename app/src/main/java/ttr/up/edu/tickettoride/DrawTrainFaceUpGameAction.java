package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class DrawTrainFaceUpGameAction
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

public class DrawTrainFaceUpGameAction extends GameAction {

    private int card;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public DrawTrainFaceUpGameAction(GamePlayer player, int card) {
        super(player);
        this.card = card;
    }

    public int getCard() {
        return card;
    }
}
