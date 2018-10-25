package ttr.up.edu.tickettoride;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.GamePlayer;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.game.config.GameConfig;
import ttr.up.edu.game.config.GamePlayerType;

/**
 * class TTR_MainActivity
 *
 * is a class to extend GameMainActivity to allow for the creation and running of Ticket To Ride.
 *
 * @author Alex
 * @author Cameron
 * @author Nick
 * @author Ben
 * @version October 2018
 *
 */

public class TTR_MainActivity extends GameMainActivity implements View.OnClickListener{

    public static final int PORT_NUMBER = 5213;
    EditText editText;

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


        // Create a game configuration class for Tic-tac-toe
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,4, "Ticket_To_Ride", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 1); // dumb computer player

        // Set the initial information for the remote player
        defaultConfig.setRemoteData("Remote Player", "", 1); // red-on-yellow GUI

        //done!
        return defaultConfig;
    }

    @Override
    public LocalGame createLocalGame() {
        return new TTR_LocalGame();
    }

    @Override
    public void onClick(View button) { //connect to RunTest button
        super.onClick(button);
        editText = (EditText) findViewById(R.id.testText);

        if(button.getId() == R.id.runTestButton) {
            editText.setText("");
            TTR_GameState firstInstance = new TTR_GameState();

            /////is this how to call the deep-state constructor?
            TTR_GameState secondInstance = null;
            try {
                secondInstance = new TTR_GameState(firstInstance);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            TTR_GameState thirdInstance = new TTR_GameState();

            //////make a deep copy from thirdInstance name it fourthInstance
            TTR_GameState fourthInstance = null;
            try {
                fourthInstance = new TTR_GameState(thirdInstance);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }


            //////test game state actions
            if (firstInstance.drawFaceUp(0, 3)) {
                editText.append("\nPlayer 0 drew the third face-up card");
            }
            else{
                editText.append("\nNOT: Player 0 drew the third face-up card");
            }

            if (firstInstance.drawDeck(0)) {
                editText.append("\nPlayer 0 drew from the random deck");
            }
            else{
                editText.append("\nNOT: Player 0 drew from the random deck");
            }

            if (firstInstance.drawFaceUp(0, 1)) {
                editText.append("\nPlayer 0 is trying to draw the first face-up card.");
            }
            else{
                editText.append("\nNOT: Player 0 is trying to draw the first face-up card.");
            }

            if (firstInstance.drawRouteCards(1)) {
                editText.append("\nPlayer 1 drew 3 route cards");
            }
            else{
                editText.append("\nNOT: Player 1 drew 3 route cards");
            }

            if (firstInstance.discardRouteCard(1, 1)) {
                editText.append("\nPlayer 1 discarded the second route card");
            }
            else{
                editText.append("\nNOT: Player 1 discarded the second route card");
            }

            if (firstInstance.endTurn(1)) {
                editText.append("\nPlayer 1 has confirmed their route cards.");
            }
            else{
                editText.append("\nNOT: Player 1 has confirmed their route cards.");
            }

            //assert secondInstance.toString().equals(fourthInstance.toString());
        }
    }
}