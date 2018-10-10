package ttr.up.edu.tickettoride;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class TTRMainActivity extends edu.up.cs301.game.GameMainActivity {

    public static final int PORT_NUMBER = 5213;

    /**
     * a tic-tac-toe game is for two players. The default is human vs. computer
     */
    @Override
    public edu.up.cs301.game.config.GameConfig createDefaultConfig() {

        // Define the allowed player types
        ArrayList<edu.up.cs301.game.config.GamePlayerType> playerTypes = new ArrayList<edu.up.cs301.game.config.GamePlayerType>();

        // yellow-on-blue GUI
        playerTypes.add(new edu.up.cs301.game.config.GamePlayerType("Local Human Player (blue-yellow)") {
            public edu.up.cs301.game.GamePlayer createPlayer(String name) {
                return new TTTHumanPlayer1(name, R.layout.ttt_human_player1);
            }
        });

        // red-on-yellow GUI
        playerTypes.add(new edu.up.cs301.game.config.GamePlayerType("Local Human Player (yellow-red)") {
            public edu.up.cs301.game.GamePlayer createPlayer(String name) {
                return new TTTHumanPlayer1(name, R.layout.ttt_human_player1_flipped);
            }
        });

        // game of 33
        playerTypes.add(new edu.up.cs301.game.config.GamePlayerType("Local Human Player (game of 33)") {
            public edu.up.cs301.game.GamePlayer createPlayer(String name) {
                return new TTTHumanPlayer2(name);
            }
        });

        // dumb computer player
        playerTypes.add(new edu.up.cs301.game.config.GamePlayerType("Computer Player (dumb)") {
            public edu.up.cs301.game.GamePlayer createPlayer(String name) {
                return new TTTComputerPlayer1(name);
            }
        });

        // smarter computer player
        playerTypes.add(new edu.up.cs301.game.config.GamePlayerType("Computer Player (smart)") {
            public edu.up.cs301.game.GamePlayer createPlayer(String name) {
                return new TTTComputerPlayer2(name);
            }
        });

        // Create a game configuration class for Tic-tac-toe
        edu.up.cs301.game.config.GameConfig defaultConfig = new edu.up.cs301.game.config.GameConfig(playerTypes, 2,2, "Tic-Tac-Toe", PORT_NUMBER);

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
    public edu.up.cs301.game.LocalGame createLocalGame() {
        return new TTTLocalGame();
    }
}
