package ttr.up.edu.tickettoride;

import ttr.up.edu.game.GameComputerPlayer;
import ttr.up.edu.game.infoMsg.GameInfo;

public class TTR_GameComputerPlayer extends GameComputerPlayer {

    public TTR_GameComputerPlayer(String name){
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {

    }

    public int getPlayerNum(){
        return this.playerNum;
    }
}
