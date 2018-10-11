package ttr.up.edu.tickettoride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import ttr.up.edu.game.GameConfig;
import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.GamePlayerType;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.tickettoridegame.R;

public class TTR_MainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;


    @Override
    public GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        return null;
    }
}
