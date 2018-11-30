package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GameComputerPlayer;
import ttr.up.edu.game.infoMsg.GameInfo;

/**
 * class TTR_GameComputerPlayer
 * <p>
 * is a class to extend the GameComputerPlayer to specify it for Ticket To Ride.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 */

public class TTR_GameComputerPlayer extends GameComputerPlayer {

    public TTR_GameComputerPlayer(String name) {
        super(name);
    }


    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof TTR_GameState) {
            TTR_GameState state = (TTR_GameState) info;
            if (!(state.getCurrentPlayer() == getPlayerNum())) return;
            sleep(500);
            game.sendAction(new DrawTrainDeckGameAction(this));
            game.sendAction(new ClaimRouteGameAction(this, "Omaha<->Kansas City1"));
            game.sendAction(new ClaimRouteGameAction(this, "Omaha<->Kansas City2"));
            game.sendAction(new ClaimRouteGameAction(this, "Omaha<->Duluth1"));
            game.sendAction(new ClaimRouteGameAction(this, "Omaha<->Duluth2"));
            game.sendAction(new ClaimRouteGameAction(this, "Omaha<->Kansas City2"));
            game.sendAction(new ClaimRouteGameAction(this, "Kansas City<->Oklahoma City1"));
            game.sendAction(new ClaimRouteGameAction(this, "Kansas City<->Oklahoma City2"));
        }
    }


    public int getPlayerNum() {
        return this.playerNum;
    }
}
