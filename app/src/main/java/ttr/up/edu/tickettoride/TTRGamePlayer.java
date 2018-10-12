package ttr.up.edu.tickettoride;

import ttr.up.edu.game.Game;
import ttr.up.edu.game.GamePlayer;

public abstract class TTRGamePlayer implements Cloneable, GamePlayer{

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
