package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

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
