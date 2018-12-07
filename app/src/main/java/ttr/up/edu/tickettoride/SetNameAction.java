package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

/**
 * class SetNameAction
 * <p>
 * sets the name to display on the surface view
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version November 2018
 */

public class SetNameAction extends GameAction {
    private String name;
    private int playerNum;

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public SetNameAction(GamePlayer player, String name, int playerNum) {
        super(player);
        this.name = name;
        this.playerNum = playerNum;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getPlayerNum() {
        return playerNum;
    }
}
