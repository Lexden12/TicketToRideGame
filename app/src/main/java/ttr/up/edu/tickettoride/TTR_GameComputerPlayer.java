package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GameComputerPlayer;
import ttr.up.edu.game.infoMsg.GameInfo;
import ttr.up.edu.game.infoMsg.StartGameInfo;

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
            if(!state.isStart)
                game.sendAction(new SetNameAction(this, this.name, playerNum));
            if (!(state.getCurrentPlayer() == getPlayerNum())) return;
            sleep(500);
            for(City c:state.getGraph().cities.values()){
                for(Route r:c.getRoutes().values()){
                    game.sendAction(new ClaimRouteGameAction(this, c.name + "<->" + r.city.getName()));
                    game.sendAction(new ClaimRouteGameAction(this, c.name + "<->" + r.city.getName() + "1"));
                    game.sendAction(new ClaimRouteGameAction(this, c.name + "<->" + r.city.getName() + "2"));
                }
            }
            game.sendAction(new DrawTrainDeckGameAction(this));
            if(state.getCurrentPlayer() == playerNum)
                game.sendAction(new DrawRouteDeckGameAction(this));
        }
    }


    public int getPlayerNum() {
        return this.playerNum;
    }
}
