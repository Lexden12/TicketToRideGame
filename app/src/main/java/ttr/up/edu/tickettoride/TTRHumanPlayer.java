package ttr.up.edu.tickettoride;

import android.view.View;

import ttr.up.edu.game.GameHumanPlayer;
import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.infoMsg.GameInfo;

public class TTRHumanPlayer extends GameHumanPlayer{
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
}
