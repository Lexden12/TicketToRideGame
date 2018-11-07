package ttr.up.edu.tickettoride;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
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

public class TTR_MainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;
    EditText editText;
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


        // Create a game configuration class for Tic-tac-toe
        GameConfig defaultConfig = new GameConfig(playerTypes, 2,4, "Ticket_To_Ride", PORT_NUMBER);

        // Add the default players
        defaultConfig.addPlayer("Human", 0); // yellow-on-blue GUI
        defaultConfig.addPlayer("Computer", 3); // dumb computer player

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

    public void onClick(View button) { //connect to RunTest button
        super.onClick(button);
        if(button.getId() == R.id.runTestButton) {
            int numPlayers = game.numPlayers;
            editText = findViewById(R.id.testText);
            editText.setText("");
            TTR_GameState firstInstance = new TTR_GameState(numPlayers);

            TTR_GameState secondInstance = null;
            try {
                secondInstance = new TTR_GameState(firstInstance);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            TTR_GameState thirdInstance = new TTR_GameState(numPlayers);

            //////make a deep copy from thirdInstance name it fourthInstance
            TTR_GameState fourthInstance = null;
            try {
                fourthInstance = new TTR_GameState(thirdInstance);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }

            Card c = firstInstance.drawFaceUp(0, 3);
            if(c == null)
                editText.append("Player 0 attempted to draw the fourth face-up"
                                +" card but was unable to.\n");
            else
                editText.append("Player 0 drew a "+c.getName()+", which was"
                                +" the third face-up card\n");

            c = firstInstance.drawDeck(0);
            if(c == null)
                editText.append("Player 0 attempted to draw a random card"
                                +" from the deck, but was unable to.\n");
            else
                editText.append("Player 0 drew a "+c.getName()+", which was"
                                +" the top card of the deck\n");

            c = firstInstance.drawFaceUp(0, 1);
            if(c == null)
                editText.append("Player 0 attempted to draw the second face-up"
                                +" card, but was unable to.\n");
            else
                editText.append("Player 0 h4x and drew a "+c.getName()+", "
                                +"which was the first face-up card\n");

            Card[] cards = firstInstance.drawRouteCards(1);
            if(cards == null)
                editText.append("Player 1 attempted to draw 3 route cards, "
                                +"but was unable to.\n");
            else
                editText.append("Player 1 drew "+cards[0].getName()+", "+
                                cards[1].getName()+", and "+cards[2].getName()+", which were the"+
                                "top three route cards.\n");

            c = firstInstance.discardRouteCard(1, 1);
            if(c == null)
                editText.append("Player 1 attempted to discard the second"+
                                " route card in their hand, but was unable to.\n");
            else
                editText.append("Player 1 discarded "+c.getName()+", which was"+
                                " the second route card in their hand.\n");

            firstInstance.endTurn();
            editText.append("Player 1 has confirmed their route cards.\n");

            String second = secondInstance.toString();
            String fourth = fourthInstance.toString();
            assert second.equals(fourth);
            editText.append("The program is still running. Therefore, the second and fourth instances"+
                            "have identical toStrings\n");
            editText.append("First Instance:\n");
            editText.append(firstInstance.toString());
            editText.append("Second Instance:\n");
            editText.append(second);
            editText.append("Fourth Instance:\n");
            editText.append(fourth);
        }
    }
}