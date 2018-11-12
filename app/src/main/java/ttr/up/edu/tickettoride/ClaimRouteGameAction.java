package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.actionMsg.GameAction;

public class ClaimRouteGameAction extends GameAction {
    private String route;
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */

    public ClaimRouteGameAction(GamePlayer player, String route) {
        super(player);
        this.route = route;
    }

    public String getRoute() {
        return route;
    }
}
