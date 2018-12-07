package ttr.up.edu.tickettoride;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.game.config.GameConfig;
import ttr.up.edu.game.config.GamePlayerType;

/**
 * class TTR_MainActivity
 * <p>
 * is a class to extend GameMainActivity to allow for the creation and running of Ticket To Ride.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 */

public class TTR_MainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;
    TTR_LocalGame game;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public ttr.up.edu.game.config.GameConfig createDefaultConfig() {
        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();


        playerTypes.add(new GamePlayerType("Local Human Player") {
            public GamePlayer createPlayer(String name) {
                return new TTR_GameHumanPlayer(name, R.layout.human_player_display);
            }
        });

        playerTypes.add(new GamePlayerType("Local Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new TTR_GameComputerPlayer(name);
            }
        });

        playerTypes.add(new GamePlayerType("Local Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new TTR_SmartComputerPlayer(name);
            }
        });

        // Create a game configuration class for Tic-tac-toe
        GameConfig defaultConfig = new GameConfig(playerTypes, 2, 4, "Ticket_To_Ride", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 2); // smart computer player

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1); // red-on-yellow GUI

        //done!
        return defaultConfig;
    }

    @Override
    public LocalGame createLocalGame() {
        game = new TTR_LocalGame();
        return game;
    }
}