package ttr.up.edu.tickettoride;

import android.view.View;

import ttr.up.edu.game.GameHumanPlayer;
import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.infoMsg.GameInfo;

public class TTR_GameHumanPlayer extends GameHumanPlayer {

    TTR_GameHumanPlayer(String name){
        super(name);
    }

    @Override
    public View getTopView() {
        return null;
    }

    @Override
    public void receiveInfo(GameInfo info) {

    }

    @Override
    public void setAsGui(GameMainActivity activity) {

    }

    public int getPlayerNum(){
        return this.playerNum;
    }
}
