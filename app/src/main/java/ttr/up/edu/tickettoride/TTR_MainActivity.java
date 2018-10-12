package ttr.up.edu.tickettoride;

import android.widget.EditText;
import android.widget.TextView;

import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.LocalGame;

public class TTR_MainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;
    EditText editText;


    @Override
    public ttr.up.edu.game.config.GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        return null;
    }

    public void onClick() { //connect to RunTest button
        editText.setText("");
        TTR_GameState firstInstance = new TTR_GameState();

        /////is this how to call the deep-state constructor?
        TTR_GameState secondInstance = new TTR_GameState();

        TTR_GameState thirdInstance = new TTR_GameState();

        //////make a deep copy from thirdInstance name it fourthInstance
        TTR_GameState fourthInstance = new TTR_GameState();


        /////instructions say to add to existing text rather than replace
        /////which EditText method does that?

        firstInstance.drawFaceUp(1, 1);
        EditText.setText("Player 1 drew a face-up card", TextView.BufferType.NORMAL );

        firstInstance.drawDeck(1);
        EditText.setText("Player 1 drew from the random deck", TextView.BufferType.NORMAL );

        firstInstance.drawRouteCards(1);
        EditText.setText("Player 1 drew 3 route cards", TextView.BufferType.NORMAL );

        firstInstance.discardRouteCard(1,1);
        EditText.setText("Player 1 discarded a route card", TextView.BufferType.NORMAL );

        firstInstance.endTurn();
        EditText.setText("Player 1's turn is over.", TextView.BufferType.NORMAL );

        assert secondInstance.toString().equals(fourthInstance.toString());
    }
}