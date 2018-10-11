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

public class TTRMainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;

    /**
     * a Ticket To Ride game
     */
    @Override
    public GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // human player
        playerTypes.add(new GamePlayerType() {
            public GamePlayer createPlayer(String name) { return new TTRHumanPlayer(name); }
        });

        // dumb computer player
        playerTypes.add(new GamePlayerType("Computer Player (dumb)") {
            public GamePlayer createPlayer(String name) {
                return new TTRComputerPlayer1(name);
            }
        });

        // smarter computer player
        playerTypes.add(new GamePlayerType("Computer Player (smart)") {
            public GamePlayer createPlayer(String name) {
                return new TTRComputerPlayer2(name);
            }
        });

        // Create a game configuration class for Tic-tac-toe
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,2, "Tic-Tac-Toe", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 3); // dumb computer player

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1); // red-on-yellow GUI

        //done!
        return defaultConfig;

    }//createDefaultConfig


    /**
     * createLocalGame
     *
     * Creates a new game that runs on the server tablet,
     *
     * @return a new, game-specific instance of a sub-class of the LocalGame
     *         class.
     */
    @Override
    public LocalGame createLocalGame() {
        return new TTTLocalGame();
    }
}
