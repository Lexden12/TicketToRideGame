package ttr.up.edu.tickettoride;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import ttr.up.edu.game.GameMainActivity;
import ttr.up.edu.game.LocalGame;
import ttr.up.edu.tickettoridegame.R;

public class TTR_MainActivity extends GameMainActivity {

    public static final int PORT_NUMBER = 5213;
    EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        editText = findViewById(R.id.editText);
    }

    @Override
    public ttr.up.edu.game.config.GameConfig createDefaultConfig() {
        return null;
    }

    @Override
    public LocalGame createLocalGame() {
        return null;
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

        firstInstance.drawFaceUp(0, 1);
        editText.setText(editText.getText() + "Player 0 is trying to draw the first face-up card.");

        firstInstance.drawRouteCards(1);
        editText.setText(editText.getText() + "Player 1 drew 3 route cards");

        firstInstance.discardRouteCard(1,1);
        editText.setText(editText.getText() + "Player 1 discarded the second route card");

        firstInstance.endTurn();
        editText.setText(editText.getText() + "Player 1 has confirmed their route cards.");

        assert secondInstance.toString().equals(fourthInstance.toString());
    }
}