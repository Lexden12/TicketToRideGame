package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GameComputerPlayer;
import ttr.up.edu.game.infoMsg.GameInfo;

/**
 * class TTR_GameComputerPlayer
 *
 * is a class to extend the GameComputerPlayer to specify it for Ticket To Ride.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TTR_GameComputerPlayer extends GameComputerPlayer {

    public TTR_GameComputerPlayer(String name){
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof TTR_GameState){
            TTR_GameState state = (TTR_GameState)info;
            if(!(state.getCurrentPlayer()==getPlayerNum()))
                return;
            sleep(500);
            game.sendAction(new DrawTrainDeckGameAction(this));
        }
    }

    public int getPlayerNum(){
        return this.playerNum;
    }
}
