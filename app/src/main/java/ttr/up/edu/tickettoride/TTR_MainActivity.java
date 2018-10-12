package ttr.up.edu.tickettoride;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.LocalGame;

public class TTR_MainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;
    EditText editText;
    TTR_LocalGame localGame;
    TTR_GameHumanPlayer player;

    @Override
    public ttr.up.edu.game.config.GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        localGame = new TTR_LocalGame();
        return localGame;
    }

    public void onClick(View v) { //connect to RunTest button
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


        /////instructions say to add to existing text rather than replace
        /////which EditText method does that?

        firstInstance.drawFaceUp(0, 3);
        editText.setText(editText.getText() + "Player 0 drew the third face-up card");

        firstInstance.drawDeck(0);
        editText.setText(editText.getText() + "Player 0 drew from the random deck");

        firstInstance.drawRouteCards(1);
        editText.setText(editText.getText() + "Player 1 drew 3 route cards");

        firstInstance.discardRouteCard(2,1);
        editText.setText(editText.getText() + "Player 1 discarded a route card", TextView.BufferType.NORMAL );

        firstInstance.endTurn();
        editText.setText(editText.getText() + "Player 1's turn is over.", TextView.BufferType.NORMAL );

        assert secondInstance.toString().equals(fourthInstance.toString());
    }
}